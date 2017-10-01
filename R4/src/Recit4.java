
/*
 * Lab 4: Debugging using assertions
 * Buggy Implementation of P1
 * Authors: Sudipto Ghosh and Asa Ben-Hur
 * Date: Feb 11, 2014
 *  
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Recit4 {

	/*
	 * Argument: fileName. File is tab delimited 3-column format.
	 * Returns: array of Strings, element i contains the last column of line i.
	 * Scans the file twice, first to get the number of lines, and then to
	 * store the lines in an array.
	 */
	public String [] readTweets(String fileName) {

		// First pass: count the number of lines to get the size of the array
		int numLines = 0;

		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				scanner.nextLine();
				numLines++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}

		// allocate array of the appropriate size
		String [] result = new String[numLines];

		// 2nd pass thru the file: read and process each line and fill the array 
		// with the third column
		try {
			Scanner scanner2 = new Scanner(new File(fileName));
			int i = 0; // loop index for array
			while (scanner2.hasNextLine()) {
				String line = scanner2.nextLine();
				result[i] = line.split("\t")[2];
				i++;
			}
			scanner2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return result;
	}

	/*
	 * Argument: fileName. File is tab delimited 3-column format.
	 * Returns: array of Strings, each element is a stop word.
	 * Scans the file twice, first to get the number of lines, and then to
	 * store the lines in an array.
	 */
	public String [] readStopWords(String fileName) {

		// First pass thru the file: count the number of lines to get the size of array

		int numLines = 0;



		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				scanner.nextLine();
				numLines++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}

		// read allocate the array.
		String [] result = new String[numLines];

		// read and process each line and fill the array 
		try {
			Scanner scanner2 = new Scanner(new File(fileName));
			int i = 0; // loop index for array
			while (scanner2.hasNextLine()) {
				result[i] = scanner2.nextLine().trim();
				i++;
			}
			scanner2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return result;
	}

	/*
	 * Given an array of Strings, return the index of the word in the array if it occurs 
	 * Otherwise returns -1.
	 * Needed by mostCommonWord and mostCommonWordExcludingStopWords.
	 */ 
	private int findPosition(String word, String [] list) {
		for(int i=0; i<=list.length-1; i++) {
			if(word.toLowerCase().equals(list[i].toLowerCase()))
				return i;
		}
		return -1;
	}

	/*
	 * Argument: tweets: array of tweets
	 * Returns: most common word
	 */
	public String mostCommonWord(String [] tweets) {
		String [] emptyStopWordList = {""};
		return mostCommonWordExcludingStopWords(tweets, emptyStopWordList);

	}


	/*
	 * Argument: tweets: array of tweets
	 * Returns: most common word
	 */
	public String mostCommonWordExcludingStopWords(String [] tweets, String [] stopWords) {

		int numWords = 0;
		String[] words = new String [numWords];
		int[] counts = new int [numWords];

		for(int i=0; i<tweets.length; i++) {
			Scanner s = new Scanner(tweets[i]).useDelimiter("[ *\\-,!?.]+");
			while(s.hasNext()) {
				String word = s.next().toLowerCase();


				//If the word is in the stop words list, break!!
				if (findPosition(word, stopWords)>=0){
					break;
				}

				//Check if the word has already been added
				int index = findPosition(word, words);

				//If it has been added, increase the counter for that index
				if (index >= 0){
					counts[index]++;

				}

				//If it hasn't been added
				else {
					numWords++;
					String [] new_words = new String [numWords];
					int [] new_counts = new int [numWords];
					for (int j=0; j < numWords-1; j++){
						new_words[j] = words[j];
						new_counts[j] = counts[j];
					}
					words = new_words;
					counts = new_counts;

					words[numWords-1] = word;
					counts[numWords-1] = 1;
				}
			} 
		}

		// Go over the word counts and find the index of the biggest number.
		// If two counts are equal, returns the first word
		int maxCount = 0;
		int indexMostCommonWord = 0;
		for(int i=0; i < words.length; i++) {
			if(maxCount < counts[i]) {
				indexMostCommonWord = i;
				maxCount = counts[i];
			}
		}
		return words[indexMostCommonWord];
	}


	public static void main(String[] args) {

		Recit4 p1 = new Recit4();
		System.out.println("Reading tweets...");
		String [] tweets2 = p1.readTweets("tweets2.txt");
		System.out.println("Number of tweets: " + tweets2.length);
//		for(int i=0; i<tweets.length; i++){
//			System.out.println("[" + i + "]:" + tweets[i]);
//		}
		System.out.println("... done reading tweets");
		System.out.println("***************************************");
		System.out.println("Reading stop words...");
		String [] stopWords2 = p1.readStopWords("stopWords2.txt");
		System.out.println("Number of stop words: " + stopWords2.length);
//		for(int i=0; i<stopWords.length; i++){
//			System.out.println("[" + i + "]: " + stopWords[i]);
//		}
		System.out.println("... done reading stop words");
		System.out.println("***************************************");
		System.out.println("The most common word is " + p1.mostCommonWord(tweets2));		
		System.out.println("***************************************");
		System.out.println("The most common word excluding stop words is " + p1.mostCommonWordExcludingStopWords(tweets2, stopWords2));		

	}
}
