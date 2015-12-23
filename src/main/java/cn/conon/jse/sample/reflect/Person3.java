package cn.conon.jse.sample.reflect;

public class Person3 {

	private String name;
	private int age;

	public Person3() {

	}

	public Person3(String name) {
		this.name = name;
	}

	private Person3(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void run() {
		System.out.println("run!!!");
	}

}
