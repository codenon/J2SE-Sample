package cn.conon.j2se.sample.enumeration.enum1;
/*******************************************************************************
 * 
 * 1.枚举解决什么问题：限定某一个方法或变量的取值。
 * 2.在jdk1.5以前
 * 		2.1  可以方法体内检查用户传递进来的值是否合法，非法的话就抛异常提醒调用者参数非法
 * 		2.2  方法接收的类型由用户自定义，即然方法接收的参数类型由用户自定义的话，用户就可以限制方法只能接收哪几个参数了。
 * 3.在jdb1.5以后
 * 		直接用枚举解决(enum)
 * 	
 * 
 ******************************************************************************/
public class Student {

	private String name;
	private String grade; // A B C D E

	// alt + shift + s
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		if (!grade.matches("[ABCDE]")) { // 大家千万要记住，在程序中不能动不动就system.out
			throw new RuntimeException("对不起，参数非法!!");
		}
		this.grade = grade;
	}
}

class Student2 {

	private String name;
	private Grade grade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}

class Grade {
	private Grade() {
	};

	public static Grade A = new Grade();
	public static Grade B = new Grade();
	public static Grade C = new Grade();
	public static Grade D = new Grade();
	public static Grade E = new Grade();
}

class Student3 {

	private String name;
	private Grade2 grade2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade2 getGrade2() {
		return grade2;
	}

	public void setGrade2(Grade2 grade2) {
		this.grade2 = grade2;
	}

}

enum Grade2 { // 定义了一个类：Grade2
	A, B, C, D, E; // 这里面的每一个值就相当于一个类的对象
}
