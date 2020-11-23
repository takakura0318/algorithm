package aoj0029;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 入力を受け取るクラスを利用するための準備
		Scanner sc = new Scanner(System.in);
		
		// 単語を格納するための変数「word」を用意する
		String word = sc.next();
		
		// 文章を格納するための変数「t」を宣言する
		String t;
		
		// 合計数を格納するための変数「cnt」を宣言する
		int cnt = 0;
		
		while(true) {
			// ここで単語を受け取り続ける使用(つまり①「Nurtures」入力されて、Enterキーが押されて、比較して、➁「computer」が入力されて、、、)
			t = sc.next();
			if (t.equals("END_OF_TEXT")) break;
			
			// equalsIgnoreCase()大文字小文字を区別せずに2つの文字列を比較
			if (t.equalsIgnoreCase(word)) cnt++;
		}
		System.out.println(cnt);

	}

}
