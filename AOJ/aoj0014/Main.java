package aoj0014;

import java.util.Scanner;

/*
 * n 個の整数 ai(i=1,2,...n)を入力し、それらの最小値、最大値、合計値を求めるプログラムを作成してください。
 *
 * Sample Input
 * 5
 * 10 1 5 4 17
 * Sample Output
 * 1 17 37
 */
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 合計を格納する箱を「0」で初期化、最大値を格納する箱を「-10000000」で初期化、最小値を格納する箱を「10000000」で初期化
		long sum =0;
		int max = -10000000;
		int min = 10000000;

		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();

			sum += a;

			if(max < a) {max = a;}
			if(min > a) {min = a;}
		}

		System.out.printf("%d %d %d\n", min, max, sum);

	}
}
