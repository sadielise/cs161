import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Recit12 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException{
		int[] array = {233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		
		LinearSearch ls = new LinearSearch();
		System.out.println(ls.search(array, 1597));

		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(array, 3));
		
		RandomSearch rs = new RandomSearch();
		System.out.println(rs.search(array, 233));

//		UNCOMMENT TO TEST THE STUDENT SORT
		
		int studentCount = 0;
		Scanner scan = new Scanner(new File(args[0]));
		while(scan.hasNextLine()){
			scan.nextLine();
			studentCount++;
		}
		Student[] studentArray = new Student[studentCount];
		scan = new Scanner(new File(args[0]));
		int studentNum = 0;
		while(studentNum < studentCount){
			String line = scan.nextLine();
			String[] studentInfo = line.split(" ");
			String lastName = studentInfo[0];
			double gpa = (Double.parseDouble(studentInfo[1]));
			String g = studentInfo[2];
			studentArray[studentNum]= (new Student(lastName, gpa, g));
			studentNum++;
		}

//		PRINTS THE UNSORTED ARRAY

		for(int m = 0; m < studentArray.length; m++){
			System.out.println(studentArray[m]);
		}
		
		System.out.println("\n\n");

//		PRINTS THE SORTED ARRAY

		Arrays.sort(studentArray);
		for(int m = 0; m < studentArray.length; m++){
			System.out.println(studentArray[m]);
		}
	}

}
