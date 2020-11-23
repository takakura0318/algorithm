package aoj0302;

import java.util.Scanner;
public class Main {

	public static void main (String [] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();

		while (b > 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}

		System.out.println(a);
	}
}
