
public class BinarySearch implements Search{

	@Override
	public int search(int[] numbersToSearch, int numberToSearchFor) {

		return binarySearch(numbersToSearch, numberToSearchFor, 0, numbersToSearch.length);

	}

	public int binarySearch(int[] numbersToSearch, int numberToSearchFor, int min, int max){

		if(max <= min)
			return -1;

		int middle = (max+min)/2;

		if(numbersToSearch[middle] == numberToSearchFor)
			return middle;
		else{
			if(numbersToSearch[middle] < numberToSearchFor)
				return binarySearch(numbersToSearch, numberToSearchFor, middle++, max);
			else
				return binarySearch(numbersToSearch, numberToSearchFor, min, middle--);
		}

	}


}
