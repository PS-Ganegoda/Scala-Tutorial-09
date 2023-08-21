class Account(initialBalance: Double, val accountNumber: String) {
  private var balance: Double = initialBalance

  def getBalance: Double = balance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Invalid deposit amount.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println("Invalid withdrawal amount or insufficient funds.")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      toAccount.deposit(amount)
      println(s"Transferred $amount to ${toAccount.accountNumber}. New balance: $balance")
    } else {
      println("Invalid transfer amount or insufficient funds.")
    }
  }
}

object Main extends App {
  val account1 = new Account(1000.0, "A123")
  val account2 = new Account(500.0, "B456")

  println("Initial balances:")
  println(s"Account ${account1.accountNumber}: ${account1.getBalance}")
  println(s"Account ${account2.accountNumber}: ${account2.getBalance}")

  account1.deposit(200.0)
  account1.withdraw(100.0)
  account1.transfer(150.0, account2)

  println("Final balances:")
  println(s"Account ${account1.accountNumber}: ${account1.getBalance}")
  println(s"Account ${account2.accountNumber}: ${account2.getBalance}")
}
