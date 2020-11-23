package aoj0004;

import java.util.Scanner;

/*
 * ３つの整数a, b, cを読み込み、それらが a < b < cの条件を満たすならば"Yes"を、満たさないならば"No"を出力するプログラムを作成して下さい。
 */

public class Main {

	public static void main(String[] args) {

		Scanner num = new Scanner(System.in);

		int a = num.nextInt();
		int b = num.nextInt();
		int c = num.nextInt();

		if (a < b && b < c) {
			System.out.printf("YES\n");
		} else {
			System.out.printf("NO\n");
		}

	}

}
