package aoj0016;

import java.util.Scanner;

/* 以下のような出力するプログラムを作成しなさい
 * ユーザが5と10を入力すると↓
 * ##########
 * #........#
 * #........#
 * #........#
 * #........#
 * ##########
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(true) {
			int H = sc.nextInt();
			int W = sc.nextInt();

			if (H == 0 && W== 0) break;

			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			for(int i =0; i < W; i++) {
				sb1.append("#");
				// 端っこだけ「＃」にするif文。つまり例えば「5」が入力された場合、0番目と4番目だけを「＃」にする。else文の中では1番目～3番目「.」にする。
				if(i == 0 || i == W -1) {
					sb2.append("#");
				} else {
					sb2.append(".");
				}
			}

			for(int i = 0; i < H; i++) {
				if(i == 0 || i == H -1) {
					System.out.println(sb1.toString());	// ここのtoString()はPHPで言うvar_dump()と同じ
				} else {
					System.out.println(sb2.toString());
				}
			}
			System.out.println();

		}
		sc.close();

	}

}
