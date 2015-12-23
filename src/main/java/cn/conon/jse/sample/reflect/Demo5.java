package cn.conon.jse.sample.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class Demo5 {

	// 反射构造方法：public Person3(){
	@Test
	public void test1() throws Exception, NoSuchMethodException {

		Class clazz = Person3.class;
		Constructor c = clazz.getConstructor(null);
		Person3 p = (Person3) c.newInstance(null);

		p.run();
	}

	// 反射构造方法：public Person3(String name){
	@Test
	public void test2() throws Exception, NoSuchMethodException {

		Class clazz = Person3.class;
		Constructor c = clazz.getConstructor(String.class);
		Person3 p = (Person3) c.newInstance("abc");

		System.out.println(p.getName());
	}

	// 反射构造方法：private Person3(String name,int age){
	@Test
	public void test3() throws Exception {
		Class clazz = Person3.class;
		Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
		c.setAccessible(true);
		Person3 p = (Person3) c.newInstance("abc", 23);

		System.out.println(p.getName());
		System.out.println(p.getAge());

	}

	@Test
	public void test4() throws Exception, IllegalAccessException {
		Class clazz = Person3.class;
		Person3 p = (Person3) clazz.newInstance();
		p.run();

	}

	// 创建person3的对象有几种方式
	@Test
	public void test5() throws Exception, IllegalAccessException {
		// 第一种
		Person3 p = new Person3();

		// 第二种
		p = Person3.class.newInstance();

		// 第三种
		Class clazz = Person3.class;
		Constructor c = clazz.getConstructor(null);
		p = (Person3) c.newInstance(null);
	}
}
