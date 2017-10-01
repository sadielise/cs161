
public class Animal {

	//instance variables
	private String name;
	private int topSpeed;	

	//name setter
	public void setName(String name){

		this.name = name;
	}

	//name getter
	public String getName(){

		return this.name;
	}

	//top speed setter
	public void setTopSpeed(int topSpeed) {

		if(topSpeed < 0 || topSpeed > 70){
			throw new IllegalArgumentException("The number is out of range.");
		}
		else{
			this.topSpeed = topSpeed;
		}
	}

	//top speed getter
	public int getTopSpeed() {

		return this.topSpeed;
	}

	//Animal constructor
	public Animal(String name, int topSpeed){

		setName(name);
		setTopSpeed(topSpeed);

	}

	//toString method
	public String toString(){

		return "Name: " + this.name + "\tTop Speed: " + this.topSpeed;
	}

	//equals method
	public boolean equals(Object other){

		boolean same = false;

		Animal otherAnimal = (Animal) other;

		if(Math.abs(this.topSpeed - otherAnimal.topSpeed) <= 2)
			same = true;

		return same;
	}



}
