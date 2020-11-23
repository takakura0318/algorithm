package javakadai.calculator.process.create_operand_List;

import java.util.ArrayList;
import java.util.List;

/**
 * Listに数式をオペランド毎と演算式毎に格納する
 */
public class Main01 {

	public static void main(String[] args) {

		// 仮の値を指定する
		String input = "1+2+3+15+(235+1)";

		String[] operatorList = { "+", "-", "*", "/", "^", "(", ")" };

		// 空のListを宣言
		List<String> formattedList = new ArrayList<>();

		// 右オペランドのインデックスを取得する変数「targetRightOperandIdx」を初期化
		int targetRightOperandIdx = 0;

		for (int i = 0; i < input.length(); i++) {
			// 入力値の先頭から一文字ずつ取得する
			String oneChar = String.valueOf(input.charAt(i));

			for (String op : operatorList) {
				if (oneChar.equals(op)) {
					String leftOperand = input.substring(targetRightOperandIdx, i);
					System.out.println(leftOperand);
					if (leftOperand.length() > 0)
						formattedList.add(leftOperand);
					formattedList.add(op);
					targetRightOperandIdx = i + 1;

					break;
				}
			}
		}

		for (String string : formattedList) {
			System.out.println("@" + string);
		}

	}

}
