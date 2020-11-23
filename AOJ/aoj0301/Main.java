package aoj0301;
// アルゴリズムとデータ構造編

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 入力を受け取るための前準備
		Scanner sc = new Scanner(System.in);

		// (例)
		// 6
		// 5 2 4 6 1 3
		int n = sc.nextInt();	// (例)6
		int A[] = new int[n];	// 配列を指定されたn要素文宣言する

		// 0~6より小さい場合にループを回すを回す
		for (int i = 0; i < n; i++) {
			// 配列に6回代入
			A[i] = sc.nextInt();
		}

		/************ 縦列を出力する ***********/
		for(int i = 0; i < n; i++){
			int v = A[i];	// int v = 5  (0回目のループ) | int v = 2 (2回目のループ)
			int j = i - 1;	// int j = -1 (0回目のループ) | int j = 0 (2回目のループ)

			// もしも j が 0以上 && A[j] > 1以上の場合に
			while(j >= 0 && A[j] > v) {	// (1回目のループは条件外) | 0 >= 0 && A[0] = 2 (2回目のループ)
				A[j+1] = A[j];	// A[1] = 0;(2回目のループ)
				j--;
			}
			A[j + 1] = v;	// A[0] = 5 (0回目のループ) | A[1] = 2 (2回目のループ)
			System.out.println(A[0]);

			/************ 横列を出力する ***********/
			for(int x = 1; x < n; x++) {
				System.out.println(" " + A[x]);
			}
			System.out.println();
		}

	}

}
