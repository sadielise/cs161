import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * CS161: Programming Assignment P8
 * Spring 2014 semester
 * Skeleton code provided by instructors for the CodeBreaker assignment.
 * Date: April 30, 2014
 */
public class CodeBreaker {

	// constants defined for English. You must use the constants and not the values in your program.
	public final int NUMBER_OF_LETTERS = 26;

	// knownFrequencies stores the results obtained from the training data. 
	// Each element stores the known frequency of the corresponding letter.
	private double[] knownFrequencies = new double[NUMBER_OF_LETTERS];

	//stores the observed frequencies from the encrypted file
	private double[] observedFrequencies = new double[NUMBER_OF_LETTERS];

	//array corresponding to knownFrequencies that stores the number of times a letter occurs
	private double[] numberOfOccurences1 = new double[NUMBER_OF_LETTERS];

	//array corresponding to observedFrequencies that stores the number of times a letter occurs
	private double[] numberOfOccurences2 = new double[NUMBER_OF_LETTERS];

	//int that stores the number of letters in a file for knownFrequencies
	private int totalLetters = 0;

	// No constructor to be defined. Uses default constructor

	// This method is needed only for testing that you got the 
	// correct array of known frequency values.
	// Helps with grading and awarding partial credit.
	public double[] getKnownFrequencies() {
		return this.knownFrequencies;
	}

	// This method is needed for testing to bypass the training method while
	// testing decryption functionality in case your training method isn't 
	// working correctly. Helps with grading and providing partial credit.
	public void setKnownFrequencies(double[] knownFrequencies) {
		this.knownFrequencies = knownFrequencies;
	}

	// Implements the training step. Sets the array knownFrequencies
	public void train(String trainingFileName) {

		genericTrain(trainingFileName, knownFrequencies, numberOfOccurences1);

	}

	//generic training for a file
	public void genericTrain(String fileName, double[] frequencies, double[] occurences){
		try{

			Scanner scan = new Scanner(new File(fileName));

			//loop for going through file
			while(scan.hasNext()){

				//scan and examine each line
				String line = scan.nextLine();

				//put line in lowercase
				line = line.toLowerCase();
				for(int i = 0; i < line.length(); i++){

					//find a single character
					char c = line.charAt(i);

					//subtract 'a' to find true index
					int k = c-'a';

					//check if the index is between 0 and 25 to make sure that it's a letter
					if(k <=25 && k >=0){

						//increment number of letters
						totalLetters++;

						//get the slot at the index of the letter in the numberOfOccurences array and increment it
						occurences[k]++;

						//reset correct percentages in knownFrequencies
						for(int j = 0; j < frequencies.length; j++){
							frequencies[j] = occurences[j]/totalLetters;
						}
					}
				}
			}

			scan.close();
		}
		catch(Exception e){
			System.err.println(e);
			System.exit(0);
		}
	}

	// Decrypts the contents of the file referred to by cipherTextFileName,
	// and produces an output file called outputFileName, which contains the
	// decrypted text using the decryption algorithm in the Caesar cipher. 
	// Returns that the value of shift that was used in the Caesar cipher.
	public int decrypt(String cipherTextFileName, String outputFileName) {

		//same process used in train, but for observed frequencies
		genericTrain(cipherTextFileName, observedFrequencies, numberOfOccurences2);
		
		//find shift index
		int index = compare(observedFrequencies, knownFrequencies);

		//decrypt cipherText
		ceasarDecrypt(cipherTextFileName, outputFileName, index);

		//return shift value
		return index;

	}

	//ceasar cipher method
	public void ceasarDecrypt(String ciphertext, String outputFile, int numberOfPositions) {

		try{
			Scanner scan = new Scanner(new File(ciphertext));
			PrintWriter pw = new PrintWriter(new File(outputFile));

			while(scan.hasNext()){

				//scan the next word
				String line = scan.nextLine();
				String blankLine = "";

				//iterate through the characters of the word
				for(int i = 0; i < line.length(); i++){
					char c = line.charAt(i);

					if(c == ' ')
						c = ' ';

					else if(Character.isLowerCase(c)){

						//zero the index
						int zero = c - 'a';

						// the numberOfPositions to zero
						zero -= numberOfPositions;

						int index;

						//modulus the zero by 26
						if(zero < 0){
							index = ((zero%26 + 26)%26);
						}

						else{
							index = zero%26;
						}

						//add the index to the index of 'a'
						index += 'a';

						//cast the index back to a char
						c = (char)index;

					}

					else if(Character.isUpperCase(c)){

						//zero the index
						int zero = c - 'A';

						//add the numberOfPositions to zero
						zero -= numberOfPositions;

						int index;

						//modulus the zero by 26
						if(zero < 0)
							index = ((zero%26 + 26)%26);
						else
							index = zero%26;

						//add the index to the index of 'a'
						index += 'A';

						//cast the index back to a char
						c = (char)index;


					}

					blankLine += c;
				}	

				//add the changed word and a space
				pw.println(blankLine);
				pw.flush();
			}


			scan.close();
			pw.close();
		}

		catch(Exception e){
			System.err.println(e);
			System.exit(0);
		}

	}

	//compares observed and known and returns the shift index
	public int compare(double[] observed, double[] known){

		double[] minArray = new double[26];

		//try all shifts of the observedFrequencies array and compare
		for(int i = 0; i < 25; i++){

			//shift observed
			observed = shift(observed);

			//perform equation to compare known and observed
			double distance = 0;

			char c = 'A';
			for(int j = 0; j < 26; j++){

				distance += Math.abs(known[j] - observed[j]);

			}

			//add distance to minArray
			minArray[i] = distance;
			
		}

		//find the index of the min in minArray using helper
		int min = indexOfMin(minArray);

		return min;
	}

	public int indexOfMin(double[] array){

		double small = array[0];
		int index = 0;
		for(int i=0; i< array.length; i++){
			if(array[i] < small){
				small = array[i];
				index = i;
			}
		}
		
		//return the index
		return index;

	}

	public double[] shift(double[] array){

		double[] tempArray = new double[array.length]; 

		//find last element of array
		double temp = array[array.length - 1];

		//shift everything to the right
		for(int i = 0; i < array.length-1; i++){
			tempArray[i+1] = array[i];
		}

		//set the temp to the first slot in the array
		tempArray[0] = temp;

		array = tempArray;

		return array;

	}



	// barebones main method to test your code
	public static void main(String[] args) {
		//		 args[0] contains the filename of the training file
		//		 args[1] contains the filename of the cipher text file
		//		 args[2] contains the filename of the output file

		CodeBreaker cb = new CodeBreaker();
		cb.train(args[0]); 
		
		cb.decrypt(args[1], args[2]); 

				double[] array = {2,3,1,4,5};

		//
		//		double[] temp = cb.shift(array);
		//
		//		for(int i = 0; i < temp.length; i++){
		//			System.out.println(temp[i]);
		//		}
	}
}
