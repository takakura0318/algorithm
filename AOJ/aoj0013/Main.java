package aoj0013;

import java.util.Scanner;

/*
 * ２つの整数 a, b と１つの演算子 op を読み込んで、a op b を計算するプログラムを作成して下さい。
 * ただし、演算子 op は、"+"(和)、"-"(差)、"*"(積)、"/"(商)、のみとし、
 * 割り算で割り切れない場合は、小数点以下を切り捨てたものを計算結果とします。
 * 入力は複数のデータセットから構成されています。各データセットの形式は以下のとおりです：
 *・a op b
 *・op が '?' のとき 入力の終わりを示します。このケースの出力は行ってはいけません。
 */
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			int a = sc.nextInt();
			String op = sc.next();
			int b = sc.nextInt();

			if (op.equals("?"))break;

			int ans =0;

			switch (op) {
			case "+":
				ans = a+b;
				break;

			case "-":
				ans = a-b;
				break;

			case "*":
				ans = a*b;
				break;

			case "/":
				ans = a/b;
				break;
			}

			System.out.println(ans);
		}

	}

}
