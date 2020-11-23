package aoj0018;

import java.util.Scanner;

/*
 * Sample Input
 * 30
 * Sample Output
 *  3 6 9 12 13 15 18 21 23 24 27 30
 *
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = 1; i <= n; i++) {
			// もしも3の倍数又は3を含む数字の場合は
			if(i % 3 == 0 || Integer.toString(i).contains("3")) {
				System.out.print(" "+i);
			}
		}
		System.out.println();

	}

}
