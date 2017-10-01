import java.util.Random;


public class Tester extends Employee{

	private int linesOfCodeTestedPerDay;
	
	public Tester(String name, int id, int numLines) {
		super(name, id, numLines);
		linesOfCodeTestedPerDay = numLines;
	}
	
	Random rnd = new Random();

	@Override
	public int work() {
		return (int) (linesOfCodeTestedPerDay * ((int)(rnd.nextInt(50) + 125)/(0.01)));

	}

}
