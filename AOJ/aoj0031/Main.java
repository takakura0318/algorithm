package aoj0031;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 最初の単語を受け取る
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder(sc.nextLine());

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {

			String order = sc.next();

			// 変数aは第1引数で使用する
			int a = sc.nextInt();
			// 変数bは第2引数で使用する
			int b = sc.nextInt()+1;

			if (order.equals("print")) {

				System.out.println(str.substring(a, b));	// substring()メソッド。a文字目からb文字目の手前まで引き抜く

			} else if(order.equals("reverse")) {

				// replace(int a, int b, String s)。	a番目～b番目の文字をsに置き換える
				// (例)「axyze」→「yxaze」にする。つまり 0 文字目から 2 文字目までを逆順にする。
				str.replace(a, b, new StringBuilder(str.substring(a, b)).reverse().toString());

			} else {
				String s = sc.next();
				str.replace(a, b, s);
			}
		}

	}

}
