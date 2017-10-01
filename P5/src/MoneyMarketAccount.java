
public class MoneyMarketAccount extends Account{

	//	A money market account gives you higher interest, but offers a limited number 
	//	of deposits and withdrawsls. A maximum of 6 transactions (deposits or withdrawals) 
	//	is allowed per month. If a withdrawal causes the balance to go below $10,000, 
	//	a fee of $100 is imposed and no more transactions are allowed until the balance 
	//	is increased using a deposit transaction. A deposit performed to reach or exceed 
	//	the minimum balance is not counted as part of the 6 transactions.

	//variable to track the number of transactions
	private int numberOfTransactions;


	public MoneyMarketAccount(String id, double initialBalance) throws Exception{

		//initial balance cannot be less than $10,000
		if(initialBalance < 10000)
			throw new Exception("Insufficient starting balance");

		//call Account superclass constructor
		super(id, initialBalance);
	}

	public void withdraw(double amount) throws Exception{

		//check balance. if less than $10,000, throw exception
		if(super.balance < 10000)
			throw new Exception("Below minimum balance");

		//check number of transactions. if more than 6, throw exception
		if(numberOfTransactions > 6)
			throw new Exception("Exceeding allowed transactions (6)");

		//find the total when the amount is subtracted from the balance
		double total = super.balance - amount;

		//if the withdraw causes the balance to go below $10,000, impose a fee of $100
		if(total < 10000)
			super.balance = total - 100;
		//perform withdraw
		else
			super.balance = total;

	}

	public void deposit(double amount) throws Exception{

		//check number of transactions. if more than 6, throw exception
		if(numberOfTransactions > 6)
			throw new Exception("Exceeding allowed transactions (6)");

		//perform deposit
		super.balance += amount;

	}
	
	public double addInterest(double rate){
		
		//find the interest by multiplying the balance by the rate/100 (decimal)
		double interest = balance*(rate/100);
		
		//add the interest to the balance
		super.balance += interest;
		
		//return the amount of interest
		return balance*(rate/100);
	}
	
	public void resetNumberOfTransactions(){
		numberOfTransactions = 0;
	}
	
	
	
	
	
	
	
	
	
}