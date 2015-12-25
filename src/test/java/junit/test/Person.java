package junit.test;

public class Person {
	public void eat() {
		System.out.println("eat!!!");
		// throw new RuntimeException("aahha");
	}

	public void run() {
		System.out.println("run!!!");
	}

	public static void main(String[] args) {
		Person p = new Person();
		p.eat();
		// p.run();
	}
}
