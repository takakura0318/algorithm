package javakadai.calculator.process.substring;

/**
 * 閉じ括弧の直前の文字が演算子だった場合、左括弧の隣のオペランドから閉じ括弧の隣の演算子の隣のオペランドまでを切り抜く<br>
 * Input:1+2+3+(4+5+)<br>
 * Output:4+5
 */
public class Main01 {

	public static void main(String[] args) {

		// 演算子リスト
		String[] operatorList = { "+", "-", "*", "/", "^" };

		// 仮の値を指定する
		String input = "1+2+3+(4+5+)";

		// 閉じ括弧のインデックス番号を宣言
		int rightBrancketIdx = 0;
		// 閉じ括弧の直前の演算子のインデックス番号を宣言
		int opIdx = 0;
		// 閉じ括弧に対応する左括弧のインデックス番号を宣言
		int leftBrancketIdx = 0;

		for (int i = 0; i < input.length(); i++) {
			// 入力値の先頭から一文字取得する
			String oneChar = String.valueOf(input.charAt(i));

			// もしも入力値が閉じ括弧の場合
			if (oneChar.equals(")")) {
				// 入力文字列の中で右括弧が見つかったインデックスを取得する
				rightBrancketIdx = i;

				for (String op : operatorList) {
					// もしも閉じ括弧の直前の文字が演算子だった場合
					if (String.valueOf(input.charAt(i - 1)).equals(op)) {
						// 右括弧の直前の文字が演算子だった場合の演算子のインデックス番号を取得する
						opIdx = i - 1;
						// 左括弧のインデックス番号を取得する
						leftBrancketIdx = input.lastIndexOf("(", rightBrancketIdx);
					}
				}
			}
		}

		String kirinuki = input.substring(leftBrancketIdx + 1, opIdx);
		System.out.println(kirinuki); // ★実行結果：4+5 切り抜き前：1+2+3+(4+5+)

	}

}
