import java.util.Random;


public class RandomSearch implements Search{

	@Override
	public int search(int[] numbersToSearch, int numberToSearchFor) {

		Random r = new Random();

		int index = 0;

		for(int i = 0; i < 5; i++){

			index = r.nextInt(numbersToSearch.length);
			if(numbersToSearch[index] == numberToSearchFor){
				return index;
			}
		}

		return -1;
	}

}
