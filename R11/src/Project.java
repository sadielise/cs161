import java.util.ArrayList;


public class Project {

	public int linesOfCode;
	public int linesOfCodeWritten = 0;
	public int linesOfCodeTested = 0;
	public int duration;
	public ArrayList<Employee> employees = new ArrayList<Employee>();
	public int numberOfDays = 0;


	public Project(int linesOfCode, int duration){
		this.linesOfCode = linesOfCode;
		this.duration = duration;
	}

	public void addEmployee(Employee e){
		employees.add(e);
	}

	public int doProject(){
		//check if the project is complete
		if(linesOfCodeWritten < linesOfCode && linesOfCodeTested < linesOfCode){
			//if not, call work for all employees
			for(int i = 0; i < employees.size(); i++){
				//if the employee is a programmer, call work and add to linesOfCodeWritten
				if(employees.get(i) instanceof Programmer){
					linesOfCodeWritten += employees.get(i).work();
					System.out.println(employees.get(i).toString() + "Lines of code: " + linesOfCodeWritten);
				}
				//if the employee is a tester, call work and add to linesOfCodeTested
				else if(employees.get(i) instanceof Tester){
					linesOfCodeTested += employees.get(i).work();
					System.out.println(employees.get(i).toString() + "Lines of code: " + linesOfCodeWritten);
				}

			}	
			
			//increase the number of days the project has taken so far
			numberOfDays++;
		}
		
		System.out.println("duration - numberOfDays: " + (duration-numberOfDays));
		return duration - numberOfDays;

	}
	
	public static void main(String[] args){
		
		Project p = new Project(5000, 10);
		p.addEmployee(new Programmer("Jeff", 123, 30));
		p.addEmployee(new Programmer("Fred", 456, 40));
		p.addEmployee(new Programmer("Sara", 789, 50));
		p.addEmployee(new Programmer("Kate", 101, 60));
		p.addEmployee(new Tester("Bob", 102, 30));
		p.addEmployee(new Tester("Greg", 103, 40));
		p.addEmployee(new Tester("Lynn", 104, 50));
		p.addEmployee(new Tester("Alice", 105, 60));
		
		p.doProject();
		
	}

}

















