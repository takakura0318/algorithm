package aoj0002;

import java.util.Scanner;

/*
 * たて a cm よこ b cm の長方形の面積と周の長さを求めるプログラムを作成して下さい。
 */

public class Main {

	public static void main(String[] args) {

		Scanner num = new Scanner(System.in);

		int n = num.nextInt();
		int m = num.nextInt();

		int s = n*m;
		int t = (n+m)*2;
		System.out.println(s + "" + t);

	}

}
