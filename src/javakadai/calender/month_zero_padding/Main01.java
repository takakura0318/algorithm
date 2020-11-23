package javakadai.calender.month_zero_padding;

/**
 * 「月」もしくは「日」の先頭に0が省略された場合は0埋めするプログラム<br>
 * Input:3 Output:03
 */
public class Main01 {

	public static void main(String[] args) {

		// 0が省略されている3月を宣言
		String month = "3";
		// テスト用(月が2桁を満たしているので0パディングはされない)
		// String month = "03";

		// 誕生月の先頭に0が省略されている場合は0埋めする
		paddingZero(month);

	}

	private static void paddingZero(String month) {

		// 月が2桁に満たない場合(つまり「%2」の場合)は先頭を0埋めする
		String paddingStr = String.format("%2s", month).replace(" ", "0");
		System.out.println(paddingStr);

	}

}
