
public class SavingsAccount extends Account{

//	This type of account requires a minimum of $10 in the account. 
//	This account allows for depositing or withdrawing from ATM machines. 
//	No fees are charged for depositing. 
//	Withdrawing money incurs a transaction fee of $2 per withdrawal that is 
//	taken out of the balance. Any withdrawal that causes the balance to 
//	go below $10 (because of the amount to be withdrawn plus the fee) is disallowed. 
//	Interest amount is calculated and added to the balance every quarter.
	
	public SavingsAccount(String id, double initialBalance) throws Exception{
		
		//call Account superclass constructor
		super(id, initialBalance);

		//initial balance cannot be less than $10.00
		if(initialBalance < 10.00)
			throw new Exception("Insufficient starting balance");
	}
	
	public void withdraw(double amount) throws Exception{
		
		//find the total of subtracting amount and $2 transaction fee from the balance
		double total = super.balance - amount - 2;
		
		//if the withdraw will cause the account balance to drop below $10, throw exception
		if(total < 10.00)
			throw new Exception("Insufficient funds(10");
		
		//otherwise, perform the withdraw with the transaction fee
		else
			super.balance = total;
	}
	
	public double addInterest(double rate){
		
		//find the interest by multiplying the balance by the rate/100 (decimal)
		double interest = balance*(rate/100);
		
		//add the interest to the balance
		super.balance += interest;
		
		//return the amount of interest
		return balance*(rate/100);

	}

	
}
