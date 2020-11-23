package aoj0017;

import java.util.Scanner;

/*
 * 以下のような、たてH cm よこ W cm のチェック柄の長方形を描くプログラムを作成して下さい。
 * Sample Input
 * 5 6
 * Sample Output
 * #.#.#.
 * .#.#.#
 * #.#.#.
 * .#.#.#
 * #.#.#.
 *
 */
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// for(;;)はwhile(true)と同じ

		for(;;) {

			int H = sc.nextInt();
			int W = sc.nextInt();

			if(H == 0 && W == 0)break;

			String s = "";
			String t = "";

			for(int i = 0; i < H; i++) {
				// 条件演算子で文字列を作るプログラム
				// 「i」が2で割り切れる場合、変数sに「#」を代入。「i」が2で割り切れない場合、変数sに「.」代入。ループが終わるまで文字列連結する。
				s += ((i%2) == 0) ? "#" : ".";
				// 「i」が2で割り切れない場合、変数tに「#」を代入。「i」が2で割り切れる場合、変数tに「.」代入。ループが終わるまで文字列連結する。
				t += ((i%2) == 1) ? "#" : ".";
			}
			for(int i = 0; i < W; i++) {
				System.out.println((i % 2) == 0 ? s : t);
			}
			System.out.println();

		}

	}

}
