package aoj0003;

import java.util.Scanner;

/*
 * ２つの整数 a, b を読み込んで、a と b の大小関係を出力するプログラムを作成して下さい。
 */

public class Main {

	public static void main(String[] args) {

		Scanner num = new Scanner(System.in);

		int a = num.nextInt();
		int b = num.nextInt();

		if (a < b) {
			System.out.println("a < b");
		} else if (a > b) {
			System.out.println("a > b");
		} else {
			System.out.println("a == b");
		}

	}

}
