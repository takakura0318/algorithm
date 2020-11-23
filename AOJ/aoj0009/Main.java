package aoj0009;

import java.util.Scanner;

/*
 * ２つの整数 x, y を読み込み、それらを値が小さい順に出力するプログラムを作成して下さい。ただし、この問題は以下に示すようにいくつかのデータセットが与えられることに注意して下さい。
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x,y;

		while(true) {
			x = sc.nextInt();
			y = sc.nextInt();

			if (x == 0 && y == 0) {
				break;
			}

			System.out.println(Math.min(x, y) + " " + Math.max(x, y));

		}

	}

}
