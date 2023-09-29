package utility;

public class EncapsulationDemo {
	
	
	private String name;
	private String rollnum;
	private int age;
	
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	
	public String getrollnum() {
		return rollnum;
	}
	
	public void setrollnum(String rollnum) {
		this.rollnum=rollnum;
	}
	
	public int getage() {
		return age;
	}
	
	public void setage(int age) {
		this.age=age;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub\\
		EncapsulationDemo encap=new EncapsulationDemo();
		encap.setname("Naveen");
		encap.setrollnum("IBI09MCA29");
		encap.setage(37);
		System.out.println(encap.getname());
		System.out.println(encap.getrollnum());
		System.out.println(encap.getage());
	}

}
