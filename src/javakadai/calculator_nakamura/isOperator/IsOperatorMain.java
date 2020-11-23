package javakadai.calculator_nakamura.isOperator;

/**
 * 先頭の文字が演算子だった場合は先頭に0に追加するサンプルプログラム
 *
 * Input01:+1+2+3<br>
 * Output02:0+1+2+3<br>
 */
public class IsOperatorMain {

	public static void main(String[] args) {

		String dentakInput = "+1+2+3";

		// テスト用
		// String dentakInput = "-1+2+3";
		// String dentakInput = "*1+2+3";
		// String dentakInput = "/1+2+3";

		// 入力値の先頭が演算子なら
		if (isOperator(dentakInput.substring(0, 1))) {
			// 先頭を0埋めする
			dentakInput = padZero(dentakInput);
		}

	}

	/**
	 * 先頭に0埋めする
	 */
	private static String padZero(String dentakInput) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(dentakInput);
		stringBuilder.insert(0, "0");
		return stringBuilder.toString();
	}

	/**
	 * 先頭の文字が演算子かどうか
	 */
	private static boolean isOperator(String substring) {

		return substring.matches("[+\\-*/＋－‐―ー×÷＾^]");
	}

}
