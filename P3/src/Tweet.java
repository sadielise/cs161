import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Tweet {

	private String userID; // stores the user id (column 1 in tweets file)
	private Date date; // convert the date-time string (column 2 in the tweets file) to a java.util.Date format
	private String tweet; // stores the tweeted message (column 3 in the tweets file)

	public Tweet (String userID, String dateTime, String tweet){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		try {
			this.date = sdf.parse(dateTime);
		} catch(ParseException e) {
			System.exit(0);
		}

		this.userID = userID;
		this.tweet = tweet;

	}

	public String getUserID(){
		return this.userID;
	}

	public Date getDate(){
		return this.date;
	}

	public String getTweet(){
		return this.tweet;
	}

	public boolean equals(Object tweet){

		boolean equal = false;
		if(tweet instanceof Tweet){	
			if(tweet.equals(this.tweet));
			equal = true;
		}
		
		return equal;
	}

	public String toString(){

		return this.userID + "\t" + this.date.toString() + "\t" + this.tweet;

	}


}
