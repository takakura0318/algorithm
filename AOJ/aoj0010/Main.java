package aoj0010;

import java.util.Scanner;

/*
 * ３つの整数 a、b、c を読み込み、aから bまでの整数の中に、cの約数がいくつあるかを求めるプログラムを作成してください。
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();	// (��)5
		int b = sc.nextInt();	// (��)14
		int c = sc.nextInt();	// (��)80

		int ans = 0;

		for (int i = a; i <= b; i++) {

			if (c % i == 0) {
				ans++;
			}
		}

		System.out.println(ans);

	}

}
