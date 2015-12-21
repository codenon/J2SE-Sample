package cn.conon.j2se.sample.enumeration.enum3;

//如何设计复杂的枚举（让设计出来的枚举对象能够表示更多信息）
public enum Grade {
	A("100-90"), B("89-80"), C("79-70"), D("69-60"), E("60-0");

	private String value;

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

// 让每一个枚举对象拥有各自方法
enum Grade2 {
	// java的匿名内部内的语法
	A("100-90") {
		public String toLocaleString() {
			return "优";
		}
	},
	B("89-80") {
		public String toLocaleString() {
			return "良";
		}
	},
	C("79-70") {
		public String toLocaleString() {
			return "中";
		}
	},
	D("69-60") {
		public String toLocaleString() {
			return "差";
		}
	},
	E("60-0") {
		public String toLocaleString() {
			return "不及格";
		}
	};

	private String value;

	private Grade2(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public abstract String toLocaleString();
}
