package other.jol;

import java.util.Scanner;

public class jol_login_game {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1日1回ログインすることで貰えるA枚のコイン
		int A = sc.nextInt();
		// 月曜日～金曜日まで7連続でログインすると貰えるB枚のコイン
		int B = sc.nextInt();
		// 目標のコイン枚数
		int C = sc.nextInt();

		// コインの合計を格納する変数coinを初期化
		int coin = 0;

		// 目標のコインを得るために何日ログインすれば良いのかを格納する
		int count = 0;

		// コインの合計が目標のコイン数よりも小さい間
		while(coin < C) {

			count++;

			coin += A;
			if(count % 7 == 0){
				coin += B;
			}
		}
		System.out.println(count);

	}

}
