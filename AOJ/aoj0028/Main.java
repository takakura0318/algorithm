package aoj0028;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		int[] a = new int[128];
		int i;
		
		// ScannerのhasNext()メソッドは「引数で与えられたscの数が無くなるまで(与えられた入力がなくなるまで)ループを回すことができる。」
		while (sc.hasNext()) {
			
			// 入力された文字を小文字に変換して変数strに代入する
			str = sc.nextLine().toLowerCase();
			
			// 0～変数strの文字数未満のループを回す。例えば「This is a pen.」が入力された場合は0～9回ループを回す
			for (i = 0; i < str.length(); i++) {
				
				// CharAt()メソッドは「n番目の文字を抜き出す」メソッドである。
				// 例えば、入力された「this is a pen.」のキーに対応する値にインクリメントする
				a[str.charAt(i)]++;
				
			}
		}
		
		// アルファベットの'a'～'z'までループを回す
		for (char ch = 'a'; ch <= 'z'; ch++) {
			
			System.out.println(ch + " : " + a[ch]);
			
		}
		sc.close();

	}
}
