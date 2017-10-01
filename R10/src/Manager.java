
public class Manager extends Engineer{
	
	public Manager(String empName, int empId, int managerID){
		super(empName, empId, managerID);
	}
	
	public boolean work(){
		System.out.println("Name: " + super.getName() + " ID: " + super.getID() + " I am programming");
		return true;
	}
	
	public boolean handleCrisis(){
		System.out.println("Name: " + super.getName() + " ID: " + super.getID() + " handling a crisis");
		return true;
	}
	
	public String toString(){
		return super.toString();
	}
	
	@Override	
	public String getLabel(){
		return "Manager ";
	}

}
