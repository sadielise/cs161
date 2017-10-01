//Sadie Thompson 830-076-836

//This class, Stock, performs various functions on different kinds of stocks.
//The three instance variables that are used in the class are ticker, number of shares, and the price the stock was bought for.
//The basic methods to work with the class are getters for the instance variables, .equals(), and toString(). 
//Using this class, you can sell and add stock using the profit, add, and sell methods.
//The main method tests each of the methods which have been verified to perform correctly.

import java.util.ArrayList;

public class Stock {

	//Instance variables
	private String ticker = "";
	private int numShares;
	private double priceBought;

	//Constructor that sets the values for the instance variables
	public Stock (String ticker, int numShares, double priceBought){
		this.ticker = ticker;
		this.numShares = numShares;
		this.priceBought = priceBought;	
	}

	//Get method for ticker
	public String getTicker() {
		return ticker;
	}

	//Get method for numShares
	public int getNumShares() {
		return numShares;
	}

	//Get method for priceBought
	public double getPriceBought() {
		return priceBought;
	}

	//Equals method that returns true if two Stock instances have the same ticker and priceBought, and false otherwise
	public boolean equals(Object other){

		//boolean variable to return
		boolean match = false;

		//Check if other is an instance of Stock
		if(other instanceof Stock){

			//Cast other into a Stock
			Stock otherStock = (Stock)other;

			//Check if the ticker and priceBought variables for this stock and otherStock match
			//If true for both set match to true
			if(this.ticker.equals(otherStock.getTicker()) && (this.priceBought == otherStock.getPriceBought()))
				match = true;
		}
		//If other is not an instance of Stock, set match to false
		else
			match = false;

		return match;

	}

	//toString method that returns a string representation of a Stock instance in the following format:
	//"ticker:numShares:priceBought"
	public String toString(){
		return this.ticker + ":" + this.numShares + ":" + this.priceBought;
	}

	//method that returns the potential profit of selling a stock at a given price
	//because there is a transaction fee of $7.00, the potential profit is (price - priceBought - $7.00)
	public double profit(double price){
		return price - this.priceBought - 7.00;
	}

	//method that adds the number of shares in other to the instance of Stock
	//addition is only possible if this Stock and the other Stock have the same ticker and priceBought
	//returns true if the operation was successful and false if it was not
	public boolean add(Stock other){

		//use the .equals() method to see if the two instances of Stock have the same ticker and priceBought
		if(this.equals(other)){
			this.numShares += other.numShares;
			return true;
		}
		else
			return false;
	}

	//method that returns the total profit from selling a given number of shares for a given price
	//and updates the remaining number of shares for the instance
	//assume that numShares is not greater than the available number of shares
	public double sell(double price, int numShares){

		//update the number of shares remaining
		this.numShares -= numShares;

		//total profit is numShares times the difference in price and priceBought minus the $7.00 transaction fee
		return ((numShares) * (price - this.priceBought)) - 7.00;
	}

	//Main method
	public static void main(String[] args){

		//Create 6 different instances of Stock
		Stock stock1 = new Stock("red", 10, 2.00);
		Stock stock2 = new Stock("red", 20, 2.00);
		Stock stock3 = new Stock("yellow", 30, 3.00);
		Stock stock4 = new Stock("green", 40, 4.00);
		Stock stock5 = new Stock("blue", 50, 5.00);
		Stock stock6 = new Stock("purple", 60, 6.00);

		//Test the 3 get methods and print the results
		System.out.println("stock1 ticker (red): " + stock1.getTicker());
		System.out.println("stock1 numShares (10): " + stock1.getNumShares());
		System.out.println("stock1 priceBought (2.00): " + stock1.getPriceBought());

		//Test equals method and print the results
		System.out.println("stock1.equals(stock2): " + stock1.equals(stock2));
		System.out.println("stock1.equals(stock3): " + stock1.equals(stock3));

		//Test toString() method
		System.out.println("stock4: " + stock4);
		System.out.println("stock5: " + stock5);

		//Test profit method
		System.out.println("Profit of selling stock6 for $20.00: " + stock6.profit(20.00));

		//Test add method
		System.out.println("Add stock1 to stock2: " + stock1.add(stock2));
		System.out.println("Add stock1 to stock4: " + stock1.add(stock4));

		//Make sure that the number of shares from stock2 was added to stock1
		System.out.println("stock1 shares (30): " + stock1.getNumShares());

		//Test sell method
		System.out.println("Sell 10 shares of stock5 for $10.00: " + stock5.sell(10.00, 10));

		//Make sure that the number of shares for stock5 was updated
		System.out.println("stock5 shares (40): " + stock5.getNumShares());

		//ArrayList of stocks called myStocks
		ArrayList<Stock> myStocks = new ArrayList<Stock>();

		//Add the 6 previously created stocks to the ArrayList
		myStocks.add(stock1);
		myStocks.add(stock2);
		myStocks.add(stock3);
		myStocks.add(stock4);
		myStocks.add(stock5);
		myStocks.add(stock6);

		//Variable for total profits from loop below
		double totalProfit = 0.0;

		//Loop that sells 1 share of each stock for $10.00 and adds the profit to totalProfit
		//(only one $7.00 transaction fee for the entire transaction)
		for(int i = 0; i < myStocks.size(); i++){

			//Get the profit from selling a single stock for $10.00
			double profit = myStocks.get(i).sell(10.00, 1);

			//For the first stock, add the total profit, including transaction fee
			if(i == 0){
				totalProfit += profit;
			}

			//For the rest of the stock, add the total profit and compensate for the loss of transaction fee	
			else{
				totalProfit = totalProfit + profit + 7;
			}			
		}

		//Print the total proceeds
		System.out.println("Total Profit: " + totalProfit);




	}



}
