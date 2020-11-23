package aoj0019;

import java.util.Scanner;

/*
 * 与えられた数列を逆順に出力するプログラムを作成して下さい。
 * Sample Input 1
 * 5
 * 1 2 3 4 5
 * Sample Output 1
 * 5 4 3 2 1
 */

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}

		for(int j=n-1;j>0;j--){
			System.out.printf(a[j]+" ");
		}
		System.out.println(a[0]);

	}

}

