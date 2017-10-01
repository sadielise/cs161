import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Lab1 {



	// BEGIN PART 1

	/**EVENS, AVG, MINMAX
	 * Test if x is divisible by 3
	 * @param x integer to test
	 * @return true if x is divisible by 3
	 */
	public boolean isDivisibleBy3(int x)
	{
		if (x%3==0)
			return true;
		else return false;

	}

	/**
	 * Test if x is divisible by 5
	 * @param x integer to test
	 * @return true if x is divisible by 5
	 */
	public boolean isDivisibleBy5(int x)
	{
		if (x%5==0)
			return true;
		else return false;

	}

	/**
	 * Use helper functions isDivisibleBy3() and isDivisibleBy5() to implement.
	 *
	 * @param x integer to see if it divisible by 3, 5, or both
	 * @return "is divisible by 3" if x is divisible by 3, "is divisible by 5" if divisible by 5, or "is divisible by 3 and 5" if divisible by 3 and 5
	 */

	public String testDivisors(int x)
	{

		if(x%3==0 && x%5==0)
			return (x + " \"is divisible by 3 and 5\"");

		else if (x%3==0)
			return (x + " \"is divisible by 3\"");

		else if (x%5==0)
			return (x + " \"is divisible by 5\"");

		else
			return (x + "");


	}

	/**
	 * Print i and the result of testDivisors for all i such that first <= i <= last
	 *
	 * Example:
	 * 1
	 * 2
	 * 3 "is divisible by 3"
	 * 4
	 * 5 "is divisible by 5"
	 * ...
	 * 15 "is divisible by 3 and 5"
	 *
	 * @param first
	 * @param last
	 */

	public void testRange(int first, int last)
	{
		System.out.println("Input: first = " + first + ", last = " + last);
		System.out.println("Output:");
		for(int i = first; i <= last; i++){
			System.out.println(testDivisors(i));
		}
	}

	// END PART 1


	// BEGIN PART 2

	/**
	 * Extract all positive integers from the provided values in basic_1col.txt.
	 * Returned array is exactly as long as the number of positive integers in values.
	 * @param the name of the file to be read from
	 * @return array containing all of the positive integers in values.
	 */

	public int[] extractPositives(int[] intArray)
	{
		//Temporary variables
		int positive = 0;

		//Read only positive integers into a temporary array
		for(int i = 0; i < intArray.length; i++){
			if(intArray[i] >= 0){
				intArray[positive] = intArray[i];
				positive++;
			}
		}
		
		//Copy temporary array into smaller array
		int[] finalArray = Arrays.copyOf(intArray, positive);
		
		return finalArray;
	}



	// END PART 2


	// BEGIN PART 3

	/**
	 * Read in data from a file, print out the data in the specified format - "Name: *name*, Age:*age*" and then print out all of the names in a row.
	 *
	 * @param filename string
	 * @return nothing
	 */
	public void readAndPrint(String filename)
	{
		try{
			//Find the number of lines
			Scanner scan = new Scanner(new File(filename));
			int counter = 0;
			
			while(scan.hasNext()){
				scan.nextLine();
				counter++;
			}
			
			//Read names and ages into the array
			Scanner scan1 = new Scanner(new File(filename));
			String[] names = new String[counter];
			int[] ages = new int[counter];
			
			while(scan1.hasNext()){
				for(int i = 0; i < counter; i++){
					names[i] = scan1.next();
					ages[i] = scan1.nextInt();
				}
			}
			
			System.out.println(Arrays.toString(names));
			System.out.println(Arrays.toString(ages));
			
			for(int j = 0; j < counter; j++){
				System.out.println("Person: " + names[j] + ", Age: " + ages[j]);
			}
			
			for(int l = 0; l < counter; l++){
				System.out.print(names[l] + ", ");
			}
		
			scan.close();
			scan1.close();
		}
		catch(IOException e){
			System.out.println("Cannot find the file.");
			System.exit(-1);
		}
	}


	// END PART 3



	public static void main(String[] args)
	{

		//Part 1
		Lab1 lab = new Lab1();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first number. ");
		int first = input.nextInt();
		System.out.print("Enter the last number. ");
		int last = input.nextInt();
		System.out.println();
		lab.testRange(first, last);
		input.close();

		//Part 2
		try{
			//FIRST FILE READ
			Scanner fileScan = new Scanner(new File(args[0]));

			//read the number of numbers
			int count = 0;
			while (fileScan.hasNext()){
				fileScan.nextInt();
				count++;
			}

			fileScan.close();

			//SECOND FILE READ
			Scanner fileScan2 = new Scanner(new File(args[0]));

			//create an array
			int[] values = new int[count];
			for(int i = 0; i < count; i++){
				values[i] = fileScan2.nextInt();
			}

			fileScan2.close();

			System.out.println(Arrays.toString(lab.extractPositives(values)));
		}
		catch(IOException e){
			System.out.println("Cannot find file.");
			System.exit(-1);
		}


		//Part 3		
		lab.readAndPrint(args[1]);
	}

}
