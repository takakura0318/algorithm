package javakadai.calculator.validator.isNotMathematical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main01 {

	public static void main(String[] args) {

		// 電卓の仮入力値を用意する
		String dentakInput = "1+2+3+4-1";
		// 電卓の入力値を配列に変換
		String[] dentakInputArr = dentakInput.split("");

		if (isNotMathematical(dentakInputArr)) {
			System.out.println("数式が入力されませんでした");
		} else {
			System.out.println("数式が入力されました");
		}

	}

	/**
	 * @param dentakInputArr
	 * @return true:数式ではない false:数式である
	 */
	private static boolean isNotMathematical(String[] dentakInputArr) {

		for (String oneChardentakInput : dentakInputArr) {
			// 正規表現を用意する
			// Javaにおける正規表現のエスケープ処理は「\\(バックスラッシュ2つ OR 円マーク2つ)」で行う
			// エスケープ処理が必要な文字一覧:https://qiita.com/katsukii/items/1c1550f064b4686c04d4
			// 変数「regex」の「+」「-」「/」「*」「^」「(」「)」をエスケープ処理。本当だったら定数を使ってString.formatして実装する
			String regex = "1|2|3|4|5|6|7|8|9|\\+|\\-|\\*|\\/|\\^|\\(|\\)";

			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(oneChardentakInput);

			// もしも変数regexで指定された以外の文字が存在する場合
			if (!m.find()) {
				System.out.println("数式以外の文字入力されています。" + oneChardentakInput + "は数式ではない為、入力できません。");
				return true;
			}
		}

		return false;

	}

}
