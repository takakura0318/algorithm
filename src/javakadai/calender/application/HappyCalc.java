package javakadai.calender.application;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HappyCalc {

	private LocalDate today;
	private LocalDate birthday;
	private LocalDate retirementDay;

	public HappyCalc(LocalDate today, LocalDate birthday, LocalDate retirementDay) {
		this.today = today;
		this.birthday = birthday;
		this.retirementDay = retirementDay;
	}

	/**
	 * 現在から定年までの生涯年収を取得する
	 */
	public void calculate() {

		// 現在の年齢と取得する
		long age = getAge(this.birthday, this.today);
		// 給料 = 年齢
		int salary = getSalary(age);
		// 生涯年収を初期化
		int allSalary = 0;
		// 「明日」を格納する為の箱を用意する
		LocalDate nextDate = null;

		int addDay = 0;

		while (true) {
			nextDate = LocalDate.of(today.plusDays(addDay).getYear(), today.plusDays(addDay).getMonthValue(),
					today.plusDays(addDay).getDayOfMonth());

			// 定年日になったら終了、60歳になってから次の3月31㈰
			if (nextDate.equals(retirementDay)) {
				break;
			}

			// 毎月25日の場合
			if (isPayday(nextDate)) {
				allSalary += salary;
			}

			// 誕生日の場合
			if (isBirthday(nextDate, birthday)) {
				age = getAge(birthday, nextDate);
			}

			// 昇給日の場合
			if (isRaiseDay(nextDate)) {
				salary = getSalary(age);
			}

			// 夏のボーナスの場合 6月30日
			if (isSummerBonusDay(nextDate)) {
				allSalary += getSummerBonus(age);
			}

			// 冬のボーナスの場合 12月10日
			if (isWinterBonusDay(nextDate)) {
				allSalary += getWinterBonus(age);
			}
			addDay++;
		}

		// あなたの生涯獲得給料は
		System.out.println("あなたの生涯給料は" + allSalary);

	}

	// 冬のボーナスを取得する
	private int getWinterBonus(long age) {
		return getSalary(age) + 150000;
	}

	// 冬のボーナス日であるかどうかを判定する
	private boolean isWinterBonusDay(LocalDate targetDate) {
		return targetDate.getMonthValue() == 12 && targetDate.getDayOfMonth() == 10;
	}

	/**
	 *
	 * 夏ボーナス取得<br/>
	 * 年齢×10,000 + 100,000 を夏ボーナスとして返却する。<br/>
	 *
	 * @param age
	 *            年齢
	 * @return 年齢×10,000 + 100,000
	 */
	private int getSummerBonus(long age) {
		return getSalary(age) + 100000;
	}

	/**
	 *
	 * 夏ボーナス支給日判定<br/>
	 * 対象年月が夏ボーナス支給日かどうかを判定する。<br/>
	 *
	 * @param targetDate
	 *            対象年月
	 * @return 夏ボーナス支給日：true、夏ボーナス支給日でない：false
	 */
	private boolean isSummerBonusDay(LocalDate targetDate) {
		return targetDate.getMonthValue() == 6 && targetDate.getDayOfMonth() == 30;
	}

	/**
	 *
	 * 昇給日判定<br/>
	 * 対象年月が昇給日かどうかを判定する。<br/>
	 *
	 * @param targetDate
	 *            対象年月
	 * @return 昇給日：true、昇給日でない：false
	 */
	private boolean isRaiseDay(LocalDate targetDate) {
		return targetDate.getMonthValue() == 4 && targetDate.getDayOfMonth() == 1;
	}

	/**
	 *
	 * 誕生日判定<br/>
	 * 対象年月が誕生日かどうかを判定する。<br/>
	 *
	 * @param targetDate
	 *            対象年月
	 * @param birthday
	 *            誕生日
	 * @return 誕生日：true、誕生日でない：false
	 */
	private boolean isBirthday(LocalDate targetDate, LocalDate birthday) {
		return targetDate.getMonthValue() == birthday.getMonthValue()
				&& targetDate.getDayOfMonth() == birthday.getDayOfMonth();
	}

	/**
	 *
	 * 給料日判定<br/>
	 * 対象年月が給料日かどうかを判定する。<br/>
	 *
	 * @param targetDate
	 *            対象年月
	 * @return 給料日：true、給料日でない：false
	 */
	private boolean isPayday(LocalDate targetDate) {
		return targetDate.getDayOfMonth() == 25;
	}

	/**
	 *
	 * 給料取得<br/>
	 * 年齢×10000を給料として返却する。<br/>
	 *
	 * @param age
	 *            年齢
	 * @return 年齢×給料
	 */
	private int getSalary(long age) {
		return (int) age * 10000;
	}

	/**
	 * 誕生日と実行日から年齢を算出する。
	 *
	 * @return 誕生日
	 */
	private long getAge(LocalDate birthday, LocalDate today) {
		return ChronoUnit.YEARS.between(birthday, today);
	}

}
