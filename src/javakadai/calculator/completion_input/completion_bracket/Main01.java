package javakadai.calculator.completion_input.completion_bracket;

/**
 * 閉じかっこなしで入力された場合は、閉じかっこが省略された分だけ閉じ括弧を補完する
 */
public class Main01 {

	public static void main(String[] args) {

		// 仮の値を指定する
		String input = "(1+2+3+(((4+5+";

		int leftBracketCnt = 0; // 左括弧の数を数えるカウント変数
		int rightBracketCnt = 0;// 右括弧の数を数えるカウント変数

		// 文字列を一文字ずつ配列化
		String[] ar = input.split("");

		// 右括弧と左括弧の数を数える
		for (String str : ar) {
			// もしも左括弧だった場合
			if (str.equals("("))
				leftBracketCnt++;
			// もしも右括弧だった場合
			if (str.equals(")"))
				rightBracketCnt++;
		}

		// もしも入力値に左括弧がある場合 && 左括弧の数と右括弧の数が同じではない場合
		if (input.contains("(") && leftBracketCnt != rightBracketCnt) {
			// 括弧の差 = 左括弧 - 右括弧
			int parenthesisDifference = leftBracketCnt - rightBracketCnt;
			// 括弧の差だけ右括弧を補完する
			for (int i = 0; i < parenthesisDifference; i++) {
				input += ")";
			}
		}

		System.out.println(input); // ★実行結果：(1+2+3+(((4+5+))))
	}

}
