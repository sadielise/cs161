public class CircleOfLife {

	public static void main(String args[]){
		//Create a new Species object here, passing in the appropriate arguments
		Species first = new Species("rabbits", 100, 10.0);
		
		//print out the species' growth rate
		System.out.println(first.name + " growth rate: " + first.growthRate);

		//use the species' toString here
		System.out.println(first);
		
		//call populationInXYears here
		System.out.println(first.name + " population for in 2 years: " + first.populationInXYears(2));
		
		//Create a new Species object here, passing in the appropriate arguments using a very large number for the population (e.g. 100000000)
		Species second = new Species("cat", 1600, 35.5);
		
		//print out the species' population to make sure it is set to 1500
		System.out.println(second.name + " population: " + second.population);
		
		//call populationInXYears here, feel free to hardcode in the int to be passed to the method
		second.populationInXYears(5);
		
		//call mergeSpecies here
		first.mergeSpecies(second);
                //test that mergeSpecies is doing what you expected it to
		System.out.println(first);
				
	}
}
