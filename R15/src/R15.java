
public class R15 {
	
	public boolean isPalindrome(String word){
		String reversed = reverse(word);
		if(reversed.equals(word))
			return true;
		else
			return false;
	}
	
	public String reverse(String word){
		if(word.length() == 0)
			return word;
		else{
			return word.charAt(word.length()-1) + reverse(word.substring(0, word.length()-1));
		}
	}
	
	public static void main(String[] args){

		R15 r = new R15();
		
		System.out.println(r.isPalindrome("dog"));
	}

}
