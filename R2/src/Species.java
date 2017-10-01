
public class Species {	

//Put the instance variable here.
	String name;
	int population;
	double growthRate;

//Create a Species constructor that takes in a String for its name, an int for
//its population, and a double for its growth rate (this will represent
// percent).
	public Species (String name, int population, double growthRate){
		
		if(population < 1){
			population = 1;
		}
		else if(population > 1500){
			population = 1500;
		}
		
		if(growthRate < 1.0){
			growthRate = 1.0;
		}
		else if(growthRate > 20.0){
			growthRate = 20.0;
		}
		
		this.name = name;
		this.population = population;
		this.growthRate = growthRate;
		
	}


    //mergeSpecies adds the populations of the two species, changes the name
    //of the species to the concatenation of the two names, and the growth
    //rate to the maximum of the two growth rates
	public void mergeSpecies(Species other){
		
		population += other.population;
		name = name + other.name;
		if(other.growthRate > growthRate)
			growthRate = other.growthRate;

		
	}

	public String toString(){		
		
		return "Name of species: " + name + 
				"\nPopulation: " + population + 
				"\nGrowth Rate: " + growthRate;
	}


    //increases the population according to the growth rate of the species, i.e.
    // updates the population instance variable
    public void grow() {
        
    	population += (population * (growthRate/100.0));
    	
    }

    //returns the population of the species in x years according to its growth rate
	public int populationInXYears(int x){
	
		for(int i = 0; i < x; i++){
			grow();
		}
                return population;
	}

}
