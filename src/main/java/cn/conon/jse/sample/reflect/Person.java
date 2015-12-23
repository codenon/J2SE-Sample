package cn.conon.jse.sample.reflect;

public class Person {

	public void run() {
		System.out.println("run!!!!!!!!!!!!");
	}

	public void run(String name) {
		System.out.println("run!!!" + name);
	}

	public void run(String name, int arr[]) {
		System.out.println("run一个多个参数的!!!");
	}

	public String eat(String name) {

		return "hahah";
	}

	private String eat(int num) {

		return "wowow";
	}

	public static void eat() {
		System.out.println("eat!!!");
	}

	public static void main(String[] args) {
		System.out.println(args[0]);
	}

}
