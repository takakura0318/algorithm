package javakadai.blackjack.hund_calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ブラックジャックの手札を計算するサンプルプログラム
 */
public class Main01 {

	public static void main(String[] args) {

		// トランプカード(52枚)を取得する
		List<String> deck = createCard();

		// プレイヤを生成
		Player01 player02 = new Player01();

		// プレイヤーにカードを3枚配る
		player02.getHandList().add(deck.get(0));// デッキから引いたカードをプレイヤーの手札に追加
		deck.remove(0);// デッキから引いたカードを削除
		player02.getHandList().add(deck.get(0));
		deck.remove(0);
		player02.getHandList().add(deck.get(0));
		deck.remove(0);

		// テスト(試しにAをセットしてみる)
		//		player02.getHandList().set(0, "ハート 10");
		//		player02.getHandList().set(1, "ハート A");
		//		player02.getHandList().set(2, "ダイヤ A");

		// プレイヤーの手札を計算する
		player02.sumPoint();

		// 合計点を表示する
		System.out.println("合計点は" + player02.getHandSum());

	}

	/**
	 * トランプカード52枚を生成する
	 */
	private static List<String> createCard() {
		// トランプの種類を宣言
		String[] mark = { "スペード", "ハート", "クローバー", "ダイヤ" };
		List<String> deck = new ArrayList<String>();

		// トランプカード(52枚)作成
		for (int i = 0; i < 4; i++) {
			// 1~13回ループを回す
			for (int j = 1; j <= 13; j++) {

				if (j == 1) {
					deck.add(mark[i] + " " + "A");
				} else if (j == 11) {
					deck.add(mark[i] + " " + "J");
				} else if (j == 12) {
					deck.add(mark[i] + " " + "Q");
				} else if (j == 13) {
					deck.add(mark[i] + " " + "K");
				} else {
					deck.add(mark[i] + " " + j);// トランプカードの数字が2~10を生成する
				}

			}
		}

		// トランプカード(52枚)をシャッフル
		Collections.shuffle(deck);

		return deck;
	}

}
