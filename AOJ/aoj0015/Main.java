package aoj0015;
/*
 * たてH cm よこ W cm の長方形を描くプログラムを作成して下さい。1 cm × 1cm の長方形を '#'で表します
 * Sample Input
 * 3 4
 * 5 6
 * ####
 * ####
 * ####
 * Sample Output
 * ######
 * ######
 * ######
 * ######
 * ######
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {

			int H = sc.nextInt();
			int W = sc.nextInt();

			if(H == 0 && W== 0) break;

			for(int i =1; i <= H; i++) {
				for(int j = 1; j <= W; j++) {
					System.out.print("#");
				}
				System.out.println();
			}

			System.out.println();
		}


	}

}
