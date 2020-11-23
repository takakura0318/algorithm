package javakadai.calculator_nakamura.bigdecimal;

import java.math.BigDecimal;

/**
 * BigDecimal、小数点10以下に設定する
 */
public class Main {

	public static void main(String[] args) {

		String leftStr = "10";
		String rigthStr = "3";

		BigDecimal left = new BigDecimal(leftStr);
		BigDecimal right = new BigDecimal(rigthStr);

		// divide()メソッドの第2引数に小数点をいくつにするか設定。
		System.out.println(left.divide(right, 10, BigDecimal.ROUND_HALF_UP));
	}
}
