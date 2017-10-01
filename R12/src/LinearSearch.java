
public class LinearSearch implements Search{

	private int counter; 
	
	@Override
	public int search(int[] numbersToSearch, int numberToSearchFor) {
		for(counter = 0; counter < numbersToSearch.length; counter++){
			if (numbersToSearch[counter] == numberToSearchFor)
				break;
		}
		return counter;
	}

}
