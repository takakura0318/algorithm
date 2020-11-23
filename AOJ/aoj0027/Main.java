package aoj0027;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for(;;) {

			int ans = 0;
			String s = sc.nextLine();

            // equals()メソッドはは同値性(異なるインスタンスだけと同じ値であるか)を確認するメソッド
            // もしも変数「s」が0と等しい場合はbreakする
			if(s.equals("0"))break;

			// 例えば「123」が入力された場合は、0～3未満繰り返す。
			for(int i=0; i < s.length(); i++) {

                // Character.digit()メソッドは「数字文字に対応する数値に変換する」メソッドである。
                // CharAt()メソッドは「n番目の文字を抜き出す」メソッドである。
                // 変数「ans」に数字文字を対応する数値に変換して、n番目の文字を抜き出したものを格納する
				ans += Character.digit(s.charAt(i), 10);

			}
			System.out.println(ans);
		}


	}

}
