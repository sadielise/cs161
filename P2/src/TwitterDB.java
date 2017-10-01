import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TwitterDB {

	//Instance variables
	private String[] tweets;
	private String[] stopWords;

	public void loadTweets(String fileName){

		ArrayList<String> tweetsAL = new ArrayList<String>();

		try{

			Scanner analyzeFile = new Scanner(new File(fileName));

			//Scan each line, extracting only the tweet into the array
			while(analyzeFile.hasNext()){
				analyzeFile.next();
				analyzeFile.next();
				String temp = analyzeFile.nextLine();
				String temp2 = temp.trim();
				tweetsAL.add(temp2);
			}

			analyzeFile.close();
		}

		catch(IOException e){
			System.exit(0);
		}

		//Turn the tweet array list into a normal array
		tweets = tweetsAL.toArray(new String[tweetsAL.size()]);

	}

	public int getNumberOfTweets(){
		return tweets.length;
	}

	public String getTweet(int i){
		return tweets[i];
	}

	public void loadStopWords(String fileName){

		ArrayList<String> stopWordsAL = new ArrayList<String>();

		try{

			Scanner analyzeFile = new Scanner(new File(fileName));

			//Read the stop words into the array, trimming the white space
			while(analyzeFile.hasNext()){
				String temp = analyzeFile.nextLine();
				String temp2 = temp.trim();
				stopWordsAL.add(temp2);
			}

			analyzeFile.close();

		}

		catch(IOException e){
			System.exit(0);
		}

		//Turn the stopWords array list into a normal array and return it
		stopWords = stopWordsAL.toArray(new String[stopWordsAL.size()]);
		
	}
	
	public int getNumberOfStopWords(){
		return stopWords.length;
	}
	
	public String getStopWord(int i){
		return stopWords[i];
	}
	
	public String mostCommonWord(){
		
		//Declare string and integer arrays
		ArrayList<String> allWords = new ArrayList<String>();
		ArrayList<Integer> wordCount = new ArrayList<Integer>();
		boolean flag = false;

		//For loop that allows you to go through the tweets, word by word
		for(int i = 0; i < tweets.length; i++){

			//Create a temp variable for the single tweet
			String t = tweets[i];

			//Create a scanner for the single tweet that uses a delimiter
			Scanner scan = new Scanner(t).useDelimiter("[ *-,!?.]+");
			while(scan.hasNext()) {

				//Process each word in the tweet
				String word = scan.next();

				//Make the word lowercase
				word.toLowerCase();

				//If the flag is false, (aka, this is the first time through the loop)
				//add the word to the allWords array and add 1 to the wordCount array
				//then set the flag to true so that this won't execute again
				if(flag == false){
					allWords.add(word);
					wordCount.add(1);
					flag = true;
				}

				//Otherwise, continue through the loop
				else {

					boolean match = false;
					int SizeConstant = allWords.size();

					//Check if the word already exists in the array				
					for(int j = 0; j < SizeConstant; j++){

						//If it does already exists in the array
						if(word.equals(allWords.get(j))){

							//Replace the coinciding value in the int array with an increased number
							int oldValue = wordCount.get(j);
							int newValue = oldValue + 1;
							wordCount.set(j, newValue);
							match = true;
						}


					}

					//If it doesn't exist
					if(match == false){

						//Add it to the words array
						allWords.add(word);
						//and add 1 to the count array
						wordCount.add(1);
					}
				}

			}

			scan.close();
		}

		//declare max variable
		int max = 0;

		//Find the highest number in the counting array
		for (int k = 0; k < wordCount.size(); k++){

			if(wordCount.get(k) > max){
				max = wordCount.get(k);
			}
		}

		//Find the string associated to the max
		String mostCommon = allWords.get(wordCount.indexOf(max));


		//Return the mostCommon string
		return mostCommon;
	}
	
	public String mostCommonWordExcludingStopWords(){
		
		//Declare string and integer arrays
				ArrayList<String> allWords = new ArrayList<String>();
				ArrayList<Integer> wordCount = new ArrayList<Integer>();
				boolean flag = false;

				//For loop that allows you to go through the tweets, word by word
				for(int i = 0; i < tweets.length; i++){

					//Create a temp variable for the single tweet
					String t = tweets[i];

					//Create a scanner for the single tweet that uses a delimiter
					Scanner scan = new Scanner(t).useDelimiter("[ *-,!?.]+");
					while(scan.hasNext()) {

						//Process each word in the tweet
						String word = scan.next();

						//Make the word lowercase
						word.toLowerCase();

						//boolean for checking for a stop word
						boolean notStopWord = true;

						//compare word with each with in stopWords and set boolean if a match is found
						for(int count = 0; count < stopWords.length; count++){

							if(word.equals(stopWords[count]))
								notStopWord = false;

						}

						if(notStopWord == true){
							//If the flag is false, (aka, this is the first time through the loop)
							//add the word to the allWords array and add 1 to the wordCount array
							//then set the flag to true so that this won't execute again
							if(flag == false){
								allWords.add(word);
								wordCount.add(1);
								flag = true;
							}

							//Otherwise, continue through the loop
							else {

								boolean match = false;
								int SizeConstant = allWords.size();

								//Check if the word already exists in the array				
								for(int j = 0; j < SizeConstant; j++){

									//If it does already exists in the array
									if(word.equals(allWords.get(j))){

										//Replace the coinciding value in the int array with an increased number
										int oldValue = wordCount.get(j);
										int newValue = oldValue + 1;
										wordCount.set(j, newValue);
										match = true;
									}


								}

								//If it doesn't exist
								if(match == false){

									//Add it to the words array
									allWords.add(word);
									//and add 1 to the count array
									wordCount.add(1);
								}
							}
						}
					}

					scan.close();
				}

				//declare max variable
				int max = 0;

				//Find the highest number in the counting array
				for (int k = 0; k < wordCount.size(); k++){

					if(wordCount.get(k) > max){
						max = wordCount.get(k);
					}
				}

				//Find the string associated to the max
				String mostCommon = allWords.get(wordCount.indexOf(max));


				//Return the mostCommon string
				return mostCommon;
	}

	public static void main(String[] args){

		TwitterDB tdb = new TwitterDB();
		tdb.loadTweets("tweets.txt");
		System.out.println("Number of tweets = " + tdb.getNumberOfTweets());
		System.out.println("Tweet number 5 = " + tdb.getTweet(5));
		tdb.loadStopWords("stopWords.txt");
		System.out.println("Number of stop words = " + tdb.getNumberOfStopWords());
		System.out.println("The most common word is " + tdb.mostCommonWord());
		System.out.println("The most common word excluding stop words is " + tdb.mostCommonWordExcludingStopWords());



	}

}
