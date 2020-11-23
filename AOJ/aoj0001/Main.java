package aoj0001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * １つの整数 x を読み込んで、x の３乗を計算し結果を出力するプログラムを作成して下さい。
 */

public class Main {

	public static void main(String args[]) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int x = Integer.parseInt(br.readLine());

			System.out.printf("%d\n",x*x*x);
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
