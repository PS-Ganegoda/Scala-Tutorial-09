class Account(initialBalance: Double, val accountNumber: String) {
  private var balance: Double = initialBalance

  // ... (methods for deposit, withdraw, transfer)

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 // Deposit interest of 5%
    } else {
      balance += balance * 0.1 // Overdraft interest of 10%
    }
  }

  def getBalance: Double = balance
}

object Bank {
  def negativeBalanceAccounts(accounts: List[Account]): List[Account] = {
    accounts.filter(account => account.getBalance < 0)
  }

  def totalBalance(accounts: List[Account]): Double = {
    accounts.map(_.getBalance).sum
  }

  def applyInterestToAccounts(accounts: List[Account]): List[Account] = {
    accounts.foreach(_.applyInterest())
    accounts
  }
}

object Main extends App {
  val account1 = new Account(100.0, "A123")
  val account2 = new Account(-200.0, "B456")
  val account3 = new Account(500.0, "C789")

  val accounts = List(account1, account2, account3)

  println("Negative balance accounts:")
  val negativeAccounts = Bank.negativeBalanceAccounts(accounts)
  negativeAccounts.foreach(account => println(s"Account ${account.accountNumber}: ${account.getBalance}"))

  println("Total balance of all accounts: " + Bank.totalBalance(accounts))

  println("Applying interest to accounts:")
  val accountsWithInterest = Bank.applyInterestToAccounts(accounts)
  accountsWithInterest.foreach(account => println(s"Account ${account.accountNumber}: ${account.getBalance}"))
}
