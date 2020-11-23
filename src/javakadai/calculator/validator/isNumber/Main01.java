package javakadai.calculator.validator.isNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 入力文字列が数字かどうかを判定し、正しい値が入力されるまで入力させ続けるプログラム
 */
public class Main01 {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = null;

		// 正しい値が入力されるまで入力させる
		while (true) {
			System.out.println("数字を入力してください");

			try {
				input = reader.readLine();
				if (isNumber(input)) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("数字が入力されたのでブレイクされました。");

	}

	/**
	 * 数字かどうか
	 */
	private static boolean isNumber(String input) {

		// 入力値の長さだけループを回す
		for (int i = 0; i < input.length(); i++) {
			// 入力値の先頭から一文字ずつ取得する
			String oneChar = String.valueOf(input.charAt(i));
			// 入力文字が以下のいずれかだった場合は、trueを返す
			if (oneChar.equals("0") || oneChar.equals("1") || oneChar.equals("2") || oneChar.equals("3")
					|| oneChar.equals("4") || oneChar.equals("5") || oneChar.equals("6")
					|| oneChar.equals("7")
					|| oneChar.equals("8") || oneChar.equals("9")) {
				return true;
			}
		}
		return false;
	}

}
