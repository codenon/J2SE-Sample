package cn.conon.jse.sample.introspector;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class BeanUtilsSample {

	/**
	 * 用beanutils开发包操作bean的属性
	 * 
	 * @param args
	 * @throws ParseException
	 * @throws Exception
	 * @throws IllegalAccessException
	 */
	public static void main(String[] args) throws ParseException,
			IllegalAccessException, Exception {

		String name = "aaaa";
		String password = "123456";
		String age = "23";
		String birthday = "1980-09-09";

		test1(name, password, age, birthday);
		test2(name, password, age, birthday);
		test3(name, password, age, birthday);
	}

	private static void test1(String name, String password, String age,
			String birthday) throws ParseException {
		// 传统方式：如何客户端提交的数据封装到javabean
		Person p = new Person();
		p.setName(name);
		p.setPassword(password);
		p.setAge(Integer.parseInt(age));

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = format.parse(birthday);
		p.setBirthday(birth);
	}

	private static void test2(String name, String password, String age,
			String birthday) throws IllegalAccessException,
			InvocationTargetException {

		// 用beanUtils框架把数据封装到bean中
		// 注册转换器
		ConvertUtils.register(new Converter() {
			public Object convert(Class type, Object value) {
				if (type != Date.class) {
					throw new ConversionException("非法的参数类型！！");
				}
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					return sdf.parse((String) value);
				} catch (Exception e) {
					throw new ConversionException(e);
				}
			}
		}, Date.class);

		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);

		System.out.println(p.getBirthday());
	}

	private static void test3(String name, String password, String age,
			String birthday) throws ParseException, Exception,
			InvocationTargetException {
		// 用beanutils框架内置转换器进行转换
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);
		System.out.println(p.getBirthday());
	}

}
