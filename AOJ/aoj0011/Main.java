package aoj0011;

import java.util.Scanner;

/*
 * ２つの整数 a と b を読み込んで、以下の値を計算するプログラムを作成して下さい：
 *・a ÷ b ： d (整数)
 *・a ÷ b の余り ： r (整数)
 *・a ÷ b ： f (浮動小数点数)
 */

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.printf("%d %d %.10f\n",a/b,a%b,(double)a/b);
	}
}