package cn.conon.jse.demo.utils;

import java.text.DecimalFormat;

/**
 * 数字、数学相关操作工具类
 * 
 * @Create Date: 2012-10-16
 */
public class MathUtils {

	/**
	 * 保留指定的小数点位数
	 * 
	 * @param decimal
	 * @param f
	 * @return 返回字符串
	 */
	public static String formatFloat2Str(int decimal, float f) {
		String str = "";
		DecimalFormat format;
		switch (decimal) {
		case 1: {
			format = new DecimalFormat("######.# ");// 设置输出数值的格式为XX.X
			break;
		}
		case 2: {
			format = new DecimalFormat("######.## ");// 设置输出数值的格式为XX.XX
			break;
		}
		default:
			format = new DecimalFormat("######");// 设置输出数值的格式为XX
			break;
		}
		str = format.format(f);
		return str;
	}

	/**
	 * 保留指定的小数点位数
	 * 
	 * @param decimal
	 * @param f
	 * @return 返回double型数据
	 */
	public static double formatFloat2Double(int decimal, float f) {
		double pow = Math.pow(10, decimal);

		long value = Math.round(f * pow);

		double result = value / pow;

		return result;
		// BigDecimal b = new BigDecimal(f);
		// double ret = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		// return (float) ret;
	}

	/**
	 * 欧几里德辗转相除算法,求a、b两个数的最小公倍数
	 */
	private static int basal(int a, int b) {
		int i = a, j = b, s;
		for (; j != 0 && (s = i % j) != 0; i = j, j = s)
			; // 先求a、b的最大公约数j (欧几里德辗转相除算法)
		return (j == 0 ? 0 : (a * b / j)); // 得到最小公倍数 (=他们的乘积除以最大公约数)
	}

	/**
	 * 分治算法,求整形数组p中所有元素的最小公倍数
	 */
	public static int commonMultiple(int p[]) {
		for (int i = 0; i < p.length; i++) {
			if (p[i] == 0) {
				p[i] = 1;
			}
		}
		if (p.length <= 2) {
			return (p.length == 1 ? p[0] : basal(p[0], p[1])); // 基础步
		}
		int[] t1 = new int[p.length / 2];
		int[] t2 = new int[p.length - t1.length];
		System.arraycopy(p, 0, t1, 0, t1.length); // 划分步1
		System.arraycopy(p, t1.length, t2, 0, t2.length); // 划分步2
		p = null;
		int result1 = commonMultiple(t1); // 治理步1
		int result2 = commonMultiple(t2); // 治理步2
		return basal(result1, result2); // 组合步
	}

	/**
	 * 分治算法,求整形数组p中所有元素的最小公倍数
	 */
	public static int commonMultiple(Integer p[]) {
		for (int i = 0; i < p.length; i++) {
			if (p[i] == 0) {
				p[i] = 1;
			}
		}
		if (p.length <= 2) {
			return (p.length == 1 ? p[0] : basal(p[0], p[1])); // 基础步
		}
		Integer[] t1 = new Integer[p.length / 2];
		Integer[] t2 = new Integer[p.length - t1.length];
		System.arraycopy(p, 0, t1, 0, t1.length); // 划分步1
		System.arraycopy(p, t1.length, t2, 0, t2.length); // 划分步2
		p = null;
		int result1 = commonMultiple(t1); // 治理步1
		int result2 = commonMultiple(t2); // 治理步2
		return basal(result1, result2); // 组合步
	}

	/**
	 * 求最小值最大值
	 * 
	 * @param values
	 * @return result[0]:最小值 result[1]:最大值
	 */
	public static int[] minMax(int[] values) {
		// min:result[0]
		// max:result[1]
		int[] result = new int[] { 0, 0 };
		if (values == null) {
			return result;
		}
		int length = values.length;
		if (length == 0) {
			return result;
		}
		if (length == 1) {
			result[0] = values[0];
			result[1] = values[0];
			return result;
		}
		if (length == 2) {
			result[0] = Math.min(values[0], values[1]);
			result[1] = Math.max(values[0], values[1]);
			return result;
		}

		result[0] = Math.min(values[0], values[length - 1]);
		result[1] = Math.max(values[0], values[length - 1]);

		int min = result[0];
		int max = result[1];
		int count = length / 2;
		for (int i = 1; i <= count; i++) {
			int front = values[i];
			int back = values[length - i - 1];
			if (front > back) {
				if (front > max) {
					max = front;
				}
				if (back < min) {
					min = back;
				}
			} else {
				if (front < min) {
					min = front;
				}
				if (back > max) {
					max = back;
				}
			}
		}
		// ---------------------------------------------
		return result;
	}

}
