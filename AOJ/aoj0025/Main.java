package aoj0025;

import java.util.Scanner;

/*
 * Sample Input
 * 4 5
 * 1 1 3 4 5
 * 2 2 2 4 5
 * 3 3 0 1 1
 * 2 3 4 4 6
 * Sample Output
 * 1 1 3 4 5 14
 * 2 2 2 4 5 15
 * 3 3 0 1 1 8
 * 2 3 4 4 6 19
 * 8 9 9 13 17 56
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();	// 4
		int c = sc.nextInt();	// 5

		// (例)int[][] hairetu = new int[4][5];
		int[][] hairetu = new int[r][c];

		for(int i = 0; i < r; i++) {
			for (int j =0; j < c; j++) {
				hairetu[i][j] = sc.nextInt();
			}
		}

		// (例)int[] csum = new int[5];
		int[] csum = new int[c];

		for(int i =0; i < r; i++) {
			int rsum = 0;
			for(int j = 0; j < c; j++) {
				rsum += hairetu[i][j];
				// 1回目のループでcsum[0] += 1+1+3+4+5。2回目のループでcsum[1]
				csum[j] += hairetu[i][j];
				System.out.print(hairetu[i][j] + " ");
			}
			// 「14」 「15」 「8」 「19」 「56」を出力する
			System.out.println("rsum�̒��g��" + rsum);
		}
		int sum = 0;
		for (int i = 0; i < c; i++) {
			sum += csum[i];
			// 「8」 「9」 「9」 「13」 「17」
			System.out.print(csum[i] + " ");
		}
		//
		System.out.println("csum�̒��g��" + sum);

	}

}
