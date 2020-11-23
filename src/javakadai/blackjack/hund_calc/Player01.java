package javakadai.blackjack.hund_calc;

import java.util.ArrayList;
import java.util.List;

/**
 * ブラックジャックのPlayerクラス
 */
public class Player01 {

	/** 手札リスト */
	private List<String> handList = new ArrayList<>();

	/** 手札の合計 */
	private int handSum;

	/** Aceを引いたかどうか */
	private boolean aceFlag;

	/**
	 * 手札を合計する
	 */
	public void sumPoint() {

		// ①手札のトランプカード「J」「Q」「K」を10に変換→手札のトランプカード「A」を21に近い「1」or「11」に変換する
		// ②手札を合計する
		handListConverterAndSumPoint();

		// 合計点が21より大さい && Aceを引いていた場合、合計点-10する
		if (handSum > 21 && aceFlag) {
			handSum -= 10;
		}
	}

	/**
	 *  ①手札のトランプカード「J」「Q」「K」を10に変換→手札のトランプカード「A」を21に近い「1」or「11」に変換する
	 *  ②手札を合計する
	 */
	private void handListConverterAndSumPoint() {

		int targetIndex = 0;

		for (String card : handList) {

			// トランプカードを半角区切りで配列にする。(例)「ハート A」(文字列) →[ハート, A](配列)
			String[] cardSplit = card.split(" ");

			switch (cardSplit[1]) {

			case "J":
			case "Q":
			case "K":
				handList.set(targetIndex, cardSplit[0] + " " + 10);
				break;

			case "A":
				// 手札の合計が10以下の場合
				if (handSum <= 10) {
					// トランプカードの「A」を11に変換する
					handList.set(targetIndex, cardSplit[0] + " " + 11);
					// トランプカードが配られた最初の2枚連続でAを引いた場合に備えて+11する
					handSum += 11;
					// Aを引いた尚且つ11に変換したことがある場合はフラグを立てる
					setAceFlag(true);
				} else if (handSum >= 11) { // 11 以上の場合
					handList.set(targetIndex, cardSplit[0] + " " + 1);
				}

			}

			targetIndex++;
		}

		// 手札の合計点を初期化
		int sum = 0;
		// 手札のトランプカードを合計する
		for (String card : handList) {
			// Listの中身(トランプカード)スペース区切りで配列化
			String[] cardSplit = card.split(" ");
			int cardNum = Integer.parseInt(cardSplit[1]);
			sum += cardNum;
		}

		setHandSum(sum);

	}

	public List<String> getHandList() {
		return handList;
	}

	public void setHandList(List<String> handList) {
		this.handList = handList;
	}

	public int getHandSum() {
		return handSum;
	}

	public void setHandSum(int handSum) {
		this.handSum = handSum;
	}

	public boolean isAceFlag() {
		return aceFlag;
	}

	public void setAceFlag(boolean aceFlag) {
		this.aceFlag = aceFlag;
	}

}
