package cn.conon.jse.sample.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class Demo3 {

	/**
	 * 
	 * 解剖一个类的方法
	 * 
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws Exception
	 * @throws SecurityException
	 */
	// 解剖一个类无参的方法并运行
	public void test1() throws Exception {
		Class clazz = Class.forName("cn.conon.jse.sample.reflect.Person");

		// getMethod方法会返回类的一个方法
		Method method = clazz.getMethod("run", null);
		method.invoke(new Person(), null);
	}

	// 框架的运行原理（框架是怎么根据它读取的字符串信息，运行一个类的方法的）
	public void test2() throws Exception {
		String classname = "cn.itcast.Person";
		String methodName = "run";

		Class clazz = Class.forName(classname);
		Method method = clazz.getMethod(methodName, null);
		method.invoke(clazz.newInstance(), null);
	}

	// 解剖一个类有参的方法并运行:public void run(String name)
	@Test
	public void test3() throws Exception {
		Class clazz = Class.forName("cn.conon.jse.sample.reflect.Person");

		Method method = clazz.getMethod("run", String.class); // String.class指定参数类型
		method.invoke(new Person(), "abc");
	}

	// 解剖一个类有参的方法并运行public void run(String name,int arr[])
	@Test
	public void test4() throws Exception {
		Class clazz = Class.forName("cn.conon.jse.sample.reflect.Person");
		Method method = clazz.getMethod("run", String.class, int[].class);
		method.invoke(new Person(), "aaa", new int[]{});

	}

	// 解剖带返回值的方法public String eat(String name){
	@Test
	public void test5() throws Exception {
		Class clazz = Class.forName("cn.conon.jse.sample.reflect.Person");
		Method method = clazz.getMethod("eat", String.class);
		String result = (String) method.invoke(new Person(), "abc");
		System.out.println(result);
	}

	// 解剖私有方法private String eat(int num){
	// 对于非公有方法想得到的话，需要调用class.getDeclaredMethod
	@Test
	public void test6() throws Exception {
		Class clazz = Class.forName("cn.conon.jse.sample.reflect.Person");
		Method method = clazz.getDeclaredMethod("eat", int.class);
		method.setAccessible(true); // 暴力反射

		String result = (String) method.invoke(new Person(), 1);
		System.out.println(result);

	}

	// 解剖静态方法public static void eat(){
	@Test
	public void test7() throws Exception {
		Class clazz = Class.forName("cn.conon.jse.sample.reflect.Person");

		Method method = clazz.getMethod("eat", null);
		method.invoke(null, null);
	}

	// 解剖public static void main(String[] args)
	@Test
	public void test8() throws Exception {
		Class clazz = Class.forName("cn.conon.jse.sample.reflect.Person");

		Method method = clazz.getMethod("main", String[].class);
		String args[] = {"a", "b"};

		// public Object invoke(Object obj,Object... args) //jdk1.5
		// method.public Object invoke(Object obj,Obejct args[]) //jdk1.4

		// main
		method.invoke(null, new Object[]{args}); // jdk1.4--->jdk1.5
		method.invoke(null, (Object) args);
	}

}
