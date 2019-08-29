package entity;

public class Employee {
	private String name;
	private String id;
	private int age;
	private String gender;
	
	public Employee(String name, String id, int age, String gender) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.gender = gender;
	}
	public Employee() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}		
	
	
	


}
