import java.util.Random;


public class Engineer extends Employee{

	public Engineer(String empName, int empId, int managerID) {
		super(empName, empId, managerID);
	}

	@Override
	public boolean work(){

		Random crisisGen = new Random();
		if (crisisGen.nextInt(10) == 0) {
			return false;
		} else {
			System.out.println(this.toString() + " I am programming");
			return true;
		}
	}

	@Override
	public String toString(){
		return this.getLabel() + super.toString();
	}
	
	
	public String getLabel(){
		return "Engineer ";
	}
}
