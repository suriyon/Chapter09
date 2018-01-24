package model;

public class Student {
	private String id;
	private String name;
	private String branch;
	private int age;
	
	public Student() {
		super();
	}
	public Student(String id, String name, String branch, int age) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
