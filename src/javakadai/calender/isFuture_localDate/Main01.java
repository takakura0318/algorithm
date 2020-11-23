package javakadai.calender.isFuture_localDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 未来の日付が入力されているかどうかを判定するプログラム
 *
 */
public class Main01 {

	public static void main(String[] args) {

		// 未来の仮日付を指定する
		LocalDate ld = LocalDate.of(2020, 8, 30);

		// もしも日付が未来の場合
		if (ChronoUnit.DAYS.between(ld, LocalDate.now()) < 0) {
			System.out.println("未来の日付です");
		} else {
			System.out.println("未来の日付ではないです");
		}
	}

}
