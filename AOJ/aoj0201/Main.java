package aoj0201;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 前準備
		List<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		// 入力回数を決める
		int a = sc.nextInt();

		for(int i = 0; i < a; i++) {
			int x = sc.nextInt();
			if (x == 0) {
				// 要素を追加する
				list.add(sc.nextInt());
			} else if (x == 1) {
				// 要素を取得する
				System.out.println(list.get(sc.nextInt()));
			} else {
				// 要素を削除する
				list.remove(list.size()-1);
			}
		}

	}

}
