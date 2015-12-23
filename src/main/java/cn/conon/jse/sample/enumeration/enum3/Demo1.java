package cn.conon.jse.sample.enumeration.enum3;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Grade g = Grade.B;
		System.out.println(g.getValue());

		Grade2 g2 = Grade2.C;
		System.out.println(g2.getValue());
		System.out.println(g2.toLocaleString());

		WeekDay wd = WeekDay.Fri;
		System.out.println(wd.getValue());
	}

}
