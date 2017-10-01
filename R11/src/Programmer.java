import java.util.Random;


public class Programmer extends Employee{
	
	private int linesOfCodePerDay;
	
	public Programmer(String name, int id, int numLines) {
		super(name, id, numLines);
		linesOfCodePerDay = numLines;
	}
	
	Random rnd = new Random();

	@Override
	public int work() {
		return (int) (linesOfCodePerDay * ((int)(rnd.nextInt(100) + 50)/(0.01)));
	}

}
