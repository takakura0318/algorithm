package aoj0030;

import java.util.Scanner;

class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 太郎の合計点を初期化
		int tarowSum = 0;
		// 花子の合計点を初期化
		int hanakoSum = 0;

		for(int i=0; i < n; i++) {

			// 入力を受け取る
			String ta = sc.next();
			String ha = sc.next();

			// もしも太郎が入力した英単語が0より大きい場合は、プラス3点
			if(ta.compareTo(ha) > 0)
				tarowSum += 3;
			// もしも花子が入力した英単語が0より大きい場合は、プラス3点
			else if(ta.compareTo(ha) < 0)
				hanakoSum += 3;
			else {	// 引き分けの場合は、プラス1点
				tarowSum++;
				hanakoSum++;
			}
		}
		System.out.println(tarowSum + " " + hanakoSum);
		sc.close();
	}
}