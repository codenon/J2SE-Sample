package cn.conon.jse.sample.enumeration.enum3;

public enum WeekDay {

	Mon("一"), Tue("二"), Wed("三"), Thu("四"), Fri("五"), Sat("六"), Sun("日");

	private String value;

	private WeekDay(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
