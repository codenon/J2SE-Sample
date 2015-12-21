package cn.conon.j2se.sample.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//反射类的属性
public class Demo4 {

	// 反射：public int age;
	@Test
	public void test1() throws SecurityException, NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {

		Person2 p = new Person2();

		Class clazz = Person2.class;
		Field f = clazz.getField("age");
		f.set(p, 23);

		System.out.println(p.getAge());
	}

	// 反射： private String name;
	@Test
	public void test2() throws Exception {

		Person2 p = new Person2();

		Class clazz = Person2.class;
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);
		f.set(p, "aaaa");
		System.out.println(p.getName());
	}

	// 反射： private String name;
	@Test
	public void test3() throws Exception {

		Person2 p = new Person2();

		Class clazz = Person2.class;
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);
		String name = (String) f.get(p);
		System.out.println(name);
	}
}
