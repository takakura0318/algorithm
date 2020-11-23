package javakadai.calculator_nakamura.isSuusiki;

/**
 * 正規表現を使用して、電卓の入力値が数式かどうかを判定するサンプルプログラム
 */
public class IsSuusikiMain {

	public static void main(String[] args) {

		String dentakuInput1 = "1+2+3";

		// テスト用
		// String dentakuInput1 = "1+2+a+あ+1";

		// 入力チェックする
		if (!checkInput(dentakuInput1)) {
			System.out.println("正しい数式を入力してください");
		} else {
			System.out.println("正しい数式が入力されました。");
		}

	}

	/**
	 * 入力チェック<br>
	 */
	private static boolean checkInput(String dentakuInput1) {

		// 空文字、NULLチェックする
		if (isEmpty(dentakuInput1)) {
			return false;
		}

		// 数字・記号チェック
		// 電卓の入力値が数式かどうかを1文字ずつチェックする
		for (String charString : dentakuInput1.split("")) {
			if (!isFormulaString(charString)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 数式かどうかを正規表現で判定する
	 */
	private static boolean isFormulaString(String charString) {
		return charString.matches("[0-9０-９+\\-*/＋－‐―ー×÷＾^.,．，()（） 　]");
	}

	/**
	 * 空文字、NULLチェックする
	 */
	private static boolean isEmpty(String target) {
		return target.equals("") || target == null;
	}

}
