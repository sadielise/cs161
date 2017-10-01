public abstract class Employee {

    private String name;
    private int id;
    private int numLines;
    
    //Constructor
	public Employee(String name, int id, int numLines){
		name = this.name;
		id = this.id;
		numLines = this.numLines;
	}
    
    public String getName(){
    	return this.name;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public int getID(){
    	return this.id;
    }
    
    public void setID(int id){
    	this.id = id;
    }
    
	public int getNumLines() {
		return numLines;
	}

	public void setNumLines(int numLines) {
		this.numLines = numLines;
	}    
		
    public abstract int work();

    public String toString() {
	return name + " ID: " + id;
    } 

    public boolean equals(Object other) {
	if (other instanceof Employee && other != null) {
	    return (name.equals(((Employee)other).name) && id == ((Employee)other).id);
	}
	return false;
    }


}