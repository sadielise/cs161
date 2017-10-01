
public class Account {
	
	protected String id;//some form of account identification
	protected double balance;//stores the current balance
	
	//constructor
	public Account(String id, double initialBalance){
		this.id = id;
		this.balance = initialBalance;
	}
	
	// The provided amount gets taken out of the 
	//account as a result of an ATM transaction. No transaction fees apply. 
	public void withdraw(double amount) throws Exception{
		balance -= amount;
	}
	
	// The provided amount is added to the account 
	//as a result of an ATM transaction. No transaction fees apply.
	public void deposit(double amount) throws Exception{
		balance += amount;
	}
	
	//returns the account ID
	public String getID(){
		return this.id;
	}
	
	//returns the current balance
	public double getBalance(){
		return this.balance;
	}
}

