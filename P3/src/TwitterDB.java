import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class TwitterDB {

	private ArrayList<Tweet> tweets; // stores all the tweets

	public TwitterDB(String fileName) throws FileNotFoundException{

		tweets = new ArrayList<Tweet>();

		Scanner scan = new Scanner(new File(fileName));

		while(scan.hasNext()){

			//Read file and get 3 variables
			String temp1 = scan.next();
			String ID = temp1.trim();

			String temp2 = scan.next();
			String date = temp2.trim();

			String temp3 = scan.nextLine();
			String twitter = temp3.trim();

			//Create a new tweet using the info you just found
			Tweet newTweet = new Tweet(ID, date, twitter);

			//Add the new tweet to the tweet array
			tweets.add(newTweet);

		}

		scan.close();


	}

	public ArrayList<Tweet> tweetsBy(String userID){

		//Create array list to be returned
		ArrayList<Tweet> byUserID = new ArrayList<Tweet>();

		//Iterate through the array and find tweets with the matching user ID
		for(int i = 0; i < tweets.size(); i++){
			Tweet temp = tweets.get(i);
			String ID = temp.getUserID();
			if(userID.equals(ID))
				byUserID.add(temp);
		}

		return byUserID;
	}

	public ArrayList<Tweet> tweetsBefore(String dateTime) throws ParseException{

		//Create array list to be returned
		ArrayList<Tweet> byDate = new ArrayList<Tweet>();

		//Create datetime format and parse parameter into a Date
		Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateTime);

		for(int i = 0; i < tweets.size(); i++){
			Tweet temp = tweets.get(i);
			Date DT = temp.getDate();
			if(DT.before(date))
				byDate.add(temp);
		}

		return byDate;
	}


	public String mostCommonWord(){

		//Declare string and integer arrays
		ArrayList<String> allWords = new ArrayList<String>();
		ArrayList<Integer> wordCount = new ArrayList<Integer>();
		boolean flag = false;

		//For loop that allows you to go through the tweets, word by word
		for(int i = 0; i < tweets.size(); i++){

			//Create a temp variable for the single tweet
			String t = tweets.get(i).getTweet();

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

	public String search(String word){

		//Convert word to lowercase
		word.toLowerCase();

		//Create a temp String variable to return
		String matchingTweet = "";
		
		Boolean match = false;

		//Iterate through the tweets
		for(int i = 0; i < tweets.size(); i++){
			
			//Get tweet and make it lowercase
			String tweet = tweets.get(i).getTweet().toLowerCase();
			String tweet2 = tweets.get(i).getTweet();
			
			//If the tweet contains the specified word, get that tweet,
			//set match to true, and break.
			if(tweet.contains(word)){
				matchingTweet = tweet2;
				match = true;
				break;
			}
		}
		
		//If no match is found, return null
		if(match == false)
			matchingTweet = null;

		
		return matchingTweet;

	}

	public static void main(String[] args) throws FileNotFoundException, ParseException{


		TwitterDB tdb = new TwitterDB("tweets.txt");


		//WORKING
		ArrayList<Tweet> tweetsByUser = tdb.tweetsBy("USER_989b85bb");
		System.out.println("Tweets by USER_989b85bb: " + tweetsByUser);
		System.out.println(tweetsByUser.size());

		//WORKING
		ArrayList<Tweet> tweetsByDate = tdb.tweetsBefore("2010-03-07T18:26:13");
		System.out.println("Tweets before 2010-03-07T18:26:13 " + tweetsByDate);
		System.out.println(tweetsByDate.size());

		//WORKING
		System.out.println("Most common word: " + tdb.mostCommonWord());

		//NOT WORKING
		System.out.println("First tweet that contains spirit: " + tdb.search("string"));
	}

}
