package aoj0012;

import java.util.Scanner;

/*
 * 半径 r の円の面積と円周の長さを求めるプログラムを作成して下さい。
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double r = sc.nextDouble();

		double m = r*r*Math.PI;

		double l = 2*r*Math.PI;

		System.out.printf("%.6f %.6f",m,l);

	}

}
