
public class Test {
	
	public int recursion(int x){
		String s = "" + x;
		if(s.length() == 1)
			return x;
		return s.charAt(0) + recursion(s.charAt(1));
	}
	
	public static void main(String[] args){
		
		Test t = new Test();
		
		
	}

}
