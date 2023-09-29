package utility;

public class ParameterConstructor {
	
	String name;
	String roll;
	String dept;
	
	ParameterConstructor(String name,String roll,String dept){
		this.name=name;
		this.roll=roll;
		this.dept=dept;
		
	}

	
	public void display() {
		System.out.println(name+ " " +roll+ " " +dept);
	}
	
	
	
	/*public void setvalue(String name) {
		this.name=name;
	}
	
	public String getvalue() {
		return name;
	}*/
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRoll() {
		return roll;
	}


	public void setRoll(String roll) {
		this.roll = roll;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public static void main(String[] args) {
		
		ParameterConstructor pc=new ParameterConstructor("naveen","123eeeee","MCA");
		ParameterConstructor pc1=new ParameterConstructor("kumar","123eeee1","BE");
		ParameterConstructor pc2=new ParameterConstructor("Ashok","123eeeee2","BSC");
		pc.display();
		pc1.display();
		pc2.display();
		
		
			}

		}
