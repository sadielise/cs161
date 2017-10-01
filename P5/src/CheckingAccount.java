
public class CheckingAccount extends Account{
	
//	This account does not give any interest. It allows deposit and withdrawals through 
//	ATM machines, which incurs a fee of $1 per transaction, which is deducted from the 
//	balance. The balance cannot go below 0. An exception with the message 
//	"Insufficient balance (0)" is thrown if a withdraw may cause the balance to go below 0.
//	Checks may be used to make withdrawals. The first three check uses in a month 
//	are free, but subsequent uses add a fee of $2 to each check withdrawal. ATM 
//	withdrawals can take the balance down to zero but not below. Only checks are 
//	allowed to take the balance to -$10 (i.e., an overdraft). One or more checks 
//	can bring the balance down to -$10, but not lower. If a check use potentially 
//	lowers the balance below -$10, the check is disallowed and an Exception is thrown 
//	with the message "Insufficient funds (-10)".

	//constructor
	public CheckingAccount(String id, double initialBalance) throws Exception{

		//initial balance cannot be negative
		if(initialBalance < 0)
			throw new Exception("Negative balance");

		//call Account superclass constructor
		super(id, initialBalance);

	}

	private int numberOfChecksUsed = 0;//stores the number of checks used every month

	//	ATM withdrawals can take the balance down to zero but not below.
	public void withdraw(double amount) throws Exception{

		//find total when amount and transaction fee are subtracted from the balance
		double total = super.balance - amount - 1;

		//if the balance will stay above or equal to 0, perform the withdraw
		if(total >= 0)
			super.balance = total;	
		//otherwise, throw an exception
		else
			throw new Exception("Insufficient balance (0)");
	}
	
	public void deposit(double amount) throws Exception{
		
		//find total when amount is added and transaction fee is subtracted to/from balance
		double total = super.balance + amount - 1;
		
		//perform the deposit
		super.balance = total;
	}
	
	//makes the number of checks used zero
	public void resetChecksUsed(){
		numberOfChecksUsed = 0;
	}
	
	//allows someone to withdraw cash using checks
	public void withdrawUsingCheck(double amount) throws Exception{
		
		//find total when amount and transaction fee are subtracted from the balance
		double total = super.balance - 2 - amount;
		
		//checks can take the balance to -$10, but no lower
		if(total < -10.00)
			throw new Exception("Insufficient funds (-10)");
		//if allowed, perform the withdraw 
		else
			super.balance = total;
	}

	
}
