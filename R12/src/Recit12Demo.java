import java.util.Arrays;




public class Recit12Demo {
	
	public static void main(String[] args){
		
		int[] intArray = {4, 7, 2, 1, -6, 0, 20, -13};
		
		System.out.println(Arrays.toString(intArray));
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));
		
		String[] strArray = {"Eneida", "Elmer", "Marcela", "Vina", 
				"Alton", "Kasey", "Felipa", "Renee", "Genna", "Susanna"};
		
		System.out.println(Arrays.toString(strArray));		
		Arrays.sort(strArray);		
		System.out.println(Arrays.toString(strArray));
		
		
	}

}
