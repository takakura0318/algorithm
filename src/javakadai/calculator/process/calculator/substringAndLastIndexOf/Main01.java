package javakadai.calculator.process.calculator.substringAndLastIndexOf;

/**
 * 入力値の末尾が「+」もしくは「-」の演算子だった場合は、入力値の先頭から末尾の直前の文字までを切り抜く
 * 入力値の末尾が「*」もしくは「/」の演算子だった場合は、末尾の直前の文字から優先順位が下がった部分までの文字列を切り抜く<br>
 * Input01:1+2+3+ Output01:1+2+3<br>
 * Input02:1+2*3*4* Output02:2*3*4
 */
public class Main01 {

	public static void main(String[] args) {

		String input = "1+2+3+";
		String input2 = "1*2*3*";
		// テスト
		// String input2 = "1+2*3*";

		caseEndsWithoperator(input);

	}

	private static void caseEndsWithoperator(String input) {
		String[] operatorList = { "+", "-", "*", "/", "^" };

		for (String op : operatorList) {
			// もしも入力値の末尾が演算子だった場合
			if (input.endsWith(op)) {
				// もしも入力値の末尾が「+」もしくは入力値の末尾が「-」だった場合
				if (input.endsWith("+") || input.endsWith("-")) {
					String substringEndsWith = input.substring(0, input.length() - 1);
					System.out.println(substringEndsWith); // 実行結果:1+2+3

				}
				// もしも入力値の末尾の演算子が「*」もしくは「/」だった場合
				if (input.endsWith("*") || input.endsWith("/")) {
					// 三項演算子
					String substringEndsWith = input.lastIndexOf("+") != -1 // 文字列の後ろから検索して「+」が見つかった場合
							? input.substring(input.lastIndexOf("+") + 1, input.length() - 1) // 「+」が見つかったインデックス番号から末尾の直前の文字までを切り抜く
							: input.substring(input.lastIndexOf("-") + 1, input.length() - 1);// 「-」が見つかったインデックス番号から末尾の直前の文字までを切り抜く
					System.out.println(substringEndsWith); // ★実行結果：1*2*3

				}
			}
		}

	}

}
