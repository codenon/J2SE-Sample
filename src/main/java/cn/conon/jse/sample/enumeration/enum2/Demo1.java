package cn.conon.jse.sample.enumeration.enum2;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Grade a = Grade.A;
		// 得到枚举的名称
		System.out.println(a.name());

		Grade c = Grade.C;
		// 得到枚举的位置
		System.out.println(c.ordinal());

		// valueOf方法:把字符串形式的值，变成枚举对象
		String name = "A";
		Grade g = Grade.valueOf(name);
		System.out.println(g);

		// 得到一个枚举类的所有枚举值
		Grade gs[] = Grade.values();
		for (Grade temp : gs) {
			System.out.println(temp.name());
		}
	}
}
