package cn.conon.j2se.sample.enumeration.enum1;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setName("aaa");
		s1.setGrade("T");
		
		
		Student2 s2 = new Student2();
		s2.setName("aaa");
		s2.setGrade(Grade.A);
		
		
		Student3 s3 = new Student3();
		s3.setName("aaa");
		s3.setGrade2(Grade2.A);
	}

}
