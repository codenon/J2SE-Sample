package cn.conon.jse.sample.reflect;

public class Demo2 {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException {

		// 解剖一个类的前提，得到这个类，得到一个类的方式有三种

		Class clazz1 = Person.class;
		Class clazz2 = new Person().getClass();
		Class clazz3 = Class.forName("cn.conon.jse.sample.reflect.Person");

	}

}
