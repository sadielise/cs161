import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class GuinnessBook {

	private ArrayList<Animal> landAnimals;

	public GuinnessBook(String filename) throws FileNotFoundException{

		landAnimals = new ArrayList<Animal>();

		File animalFile = new File(filename);
		Scanner scan = new Scanner(animalFile);

		while(scan.hasNextLine()){
			String[] animalInfo = scan.nextLine().split(" ");
			String animalName = "";

			for(int i = 0; i < (animalInfo.length-1); i++){
				animalName += animalInfo[i] + " ";
			}
			animalName = animalName.trim();
			Integer topSpeed = Integer.parseInt(animalInfo[animalInfo.length-1]);

			//insert the animal into the arraylist here, don't change any of the above code
			Animal e = new Animal(animalName, topSpeed);
			landAnimals.add(e);

		}
		scan.close();
	}


	public String toString(){

		String animals = "";
		for(int j = 0; j < landAnimals.size(); j++){
			animals = animals + landAnimals.get(j) + "\n";
		}
		return animals;
	}

	private void testGuinnessBook() throws FileNotFoundException {

		// uncomment to test the method for finding animals with a given speed
		// Is there an animal whose speed is close to x (i.e. within 2mph)?

		 System.out.println("Is there an animal whose speed is around 70mph? " + landAnimals.contains(new Animal("fast animal", 70)));
		 System.out.println("Is there an animal whose speed is around 35mph? " + landAnimals.contains(new Animal("slow animal", 35)));

		//If we would like to know which animal it is:
		 System.out.println(landAnimals.get(landAnimals.indexOf(new Animal("fast animal", 70))));
		 System.out.println(landAnimals.get(landAnimals.indexOf(new Animal("slow animal", 35))));

		//Now print all the animals whose speed is around 50mph
		 System.out.println("\nAnimals whose speed is around 50mph:");
		 for(int i = 0; i < landAnimals.size(); i++){
			 int tempTopSpeed = landAnimals.get(i).getTopSpeed();
			 if(tempTopSpeed < 55 && tempTopSpeed > 45){
				 System.out.println(landAnimals.get(i));
			 }
		 }
	}

	public static void main(String args[]) throws FileNotFoundException {

		 GuinnessBook records = new GuinnessBook(args[0]);
		 System.out.println(records);
		 records.testGuinnessBook();
	}

}

