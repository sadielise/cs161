
public class Student implements Comparable<Student>{
	private String name;
	private double gpa;
	private boolean graduate;

	public Student(String lastName, double gradePoint, String graduate){
		name = lastName;
		setGPA(gradePoint);
		if(graduate.equalsIgnoreCase("G")){
			this.graduate = true;
		}
		else
			this.graduate = false;
	}

	public void setGPA(double gpa){
		if(gpa > 4.0){
			gpa = 4.0;
		}
		else if(gpa < 0.0){
			gpa = 0.0;
		}
		else 
			this.gpa = gpa;
	}

	public boolean getGraduate(){
		return graduate;
	}

	public String getName(){
		return name;
	}

	public double getGPA(){
		return gpa;
	}


	public String toString(){
		String output = "Name: " + name + " GPA: " + gpa;
		if(graduate){
			output += "  Graduate Student";
		}
		else
			output += "  Undergraduate Student";
		return output;
	}

	@Override
	public int compareTo(Student o) {
		Student s = null;
		if(o instanceof Student)
			s = (Student)o;
		else
			return -5;

		if(!this.graduate && s.graduate)
			return -1;
		else if(this.graduate && !s.graduate)
			return 1;
		else{

			if(this.gpa < s.gpa)
				return -1;
			else if(this.gpa > s.gpa)
				return 1;
			else{
				return this.name.compareTo(s.name);
			}
		}
	}
}
