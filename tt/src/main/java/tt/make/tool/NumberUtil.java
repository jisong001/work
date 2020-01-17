package tt.make.tool;

import java.util.Random;

public class NumberUtil {
	private static Random r = new Random(1);
	
	public static void main(String[] args) {
//		System.out.println(fillZero(18, 3));
		System.out.println(radom());
	}
	/**
	 * 补零
	 * @param number 原数字
	 * @param digit 位数
	 * @return
	 */
	public static String fillZero(int number, int digit) {
		String numberStr = Integer.toString(number);
		for (int i = numberStr.length(); i < digit; i++) {
			numberStr = "0" + numberStr;
		}
		return numberStr;
	}
	public static String radom() {
		return System.currentTimeMillis()+r.nextInt(1000)+"";
	}
	public static String radom(int i) {
		int i2 = r.nextInt(1000000000)+1000000000;
		long l = System.currentTimeMillis();
		return l+i2+"";
	}
}
