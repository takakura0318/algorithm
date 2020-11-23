package aoj0023;

import java.util.Scanner;

/*
 * あなたの課題は、あるクラスの数学の成績を付けるプログラムを作成することです。プログラムは複数の学生のテストの点数を読み込みます。
 * テストの点数は、中間試験の点数 m、期末試験の点数 f、再試験の点数 r で構成されています。
 * 中間試験と期末試験は 50 点満点（m, f ≤ 50）、再試験は 100 点満点 （r ≤ 100）です。
 * 試験を受けていない場合は点数を -1 とします。以下の手順で成績が付けられます：
 * ・中間試験、期末試験のいずれかを欠席した場合成績は F。
 * ・中間試験と期末試験の合計点数が 80 以上ならば成績は A 。
 * ・中間試験と期末試験の合計点数が 65 以上 80 未満ならば成績は B。
 * ・中間試験と期末試験の合計点数が 50 以上 65 未満ならば成績は C。
 * ・中間試験と期末試験の合計点数が 30 以上 50 未満ならば成績は D。 ただし、再試験の点数が 50 以上ならば成績は C。
 * ・中間試験と期末試験の合計点数が 30 未満ならば成績は F。
 * Sample Input
 * 40 42 -1
 * 20 30 -1
 * 0 2 -1
 * -1 -1 -1
 * Sample Output
 * A
 * C
 * F
 */
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		int m, f, r;
		
		while(true) {
			
			m = sc.nextInt();
			f = sc.nextInt();
			r = sc.nextInt();
			
			if(m == -1 && f == -1 && r == -1) {
				break;
			}
			
			if (m == -1 || f == -1) System.out.println("F");
			if ((m+f) >= 80) System.out.println("A");
			else if ((m+f) >= 65) System.out.println("B");
			else if ((m+f) >= 50 || (m+f) >= 30 && r >= 50) System.out.println("C");
			else if ((m+f) >= 30) System.out.println("D");
			else System.out.println("F");
			
		}
		sc.close();

	}

}
