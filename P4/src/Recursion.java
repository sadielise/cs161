//P4 Assignment
//CS161
//Sadie Thompson
//sadiet@rams.colostate.edu

import java.util.Arrays;


public class Recursion {

	public String duplicateEachCharacter(String s){
		if (s == null)
			return null;
		else if(s.length() == 0)
			return "";
		return s.substring(0, 1) + s.substring(0, 1) + duplicateEachCharacter(s.substring(1));

	}

	public int[] computeCumulativeSums(int[] numbers){

		if(numbers.length == 1)
			return numbers;
		else
			return sumHelper(numbers, 1);
	}

	public int[] sumHelper(int[] numbers, int index){

		if(index == (numbers.length-1)){
			numbers[numbers.length-1] += numbers[numbers.length - 2];
		}
		else{
			numbers[index] = numbers[index] + numbers[index-1];
			index++;
			sumHelper(numbers, index);
		}

		return numbers;


	}

	public boolean searchTable(int[][] data, int element){

		if((data.length == 1) && (data[0].length == 0))
			return false;

		else if((data.length == 1) && (data[0].length == 1)){
			if (data[0][0] == element)
				return true;
			else
				return false;
		}

		else
			return navigateArray(data, element, 0, 0);
	}

	public boolean navigateArray(int[][] data, int element, int row, int col){

		boolean b = false;

		if((row == data.length-1) && (col == data[row].length-1))
			if(b==false)
				return false;

		//if you find a match, return true
		if(element == data[row][col]){
			return true;
		}
		//go through array and compare
		if (row < data.length){
			if(col < data[row].length-1){
				col++;
				b = navigateArray(data, element, row, col);

			}
			else if(col == data[row].length-1){
				col = 0;
				row++;
				b = navigateArray(data, element, row, col);

			}
		}

		return b;
	}


	public static void main(String[] args){

		Recursion r = new Recursion();
		System.out.println(r.duplicateEachCharacter("Sadie"));
		int[] numbers = {5,6,7,2,3,1};
		System.out.println(Arrays.toString(r.computeCumulativeSums(numbers)));
		int[][] table = new int[][]{ {1} };
		System.out.println(r.searchTable(table, 1));
		System.out.println(r.searchTable(table, 35));
	}

}
