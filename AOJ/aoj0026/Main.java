package aoj0026;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// String型からchar型へ変換する為のtoCharArray()メソッド
		char[] list = sc.nextLine().toCharArray();

		for (char a : list) {

			// もしも、変数「a」の中身に小文字があった場合は
			if (Character.isLowerCase(a)) {

				// 変数「a」の中にある小文字を大文字に変換して出力する
				System.out.print(Character.toUpperCase(a));

			} else {	// それ以外の場合は

				// 変数「a」の中にある大文字を小文字に変換して出力する
				System.out.print(Character.toLowerCase(a));

			}

		}
		System.out.println();

	}

}
