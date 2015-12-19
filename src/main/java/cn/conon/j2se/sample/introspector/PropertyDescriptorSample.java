package cn.conon.j2se.sample.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class PropertyDescriptorSample {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// 传统方式访问 bean的属性
		Person p = new Person();
		p.setAge(12);

		// 用内省技术访问 bean 的属性（1）
		p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("name", Person.class);
		Method method = pd.getWriteMethod(); // 得到了setName方法
		method.invoke(p, "abc");

		method = pd.getReadMethod(); // 得到getName方法
		String value = (String) method.invoke(p, null);
		System.out.println(value);

	}

	public void test3() throws Exception {
		// 用内省技术访问 bean 的属性（2）
		BeanInfo bi = Introspector.getBeanInfo(Person.class); // 得到用于封装bean描述信息的beaninfo
		PropertyDescriptor pds[] = bi.getPropertyDescriptors();
		for (PropertyDescriptor pd1 : pds) {
			String name = pd1.getName();
			System.out.println(name);
		}
	}

}
