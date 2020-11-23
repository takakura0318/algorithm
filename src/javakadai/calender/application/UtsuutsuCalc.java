package javakadai.calender.application;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import ajd4jp.AJD;
import ajd4jp.AJDException;
import ajd4jp.Holiday;

public class UtsuutsuCalc {

	private LocalDate today;
	private LocalDate birthday;
	private LocalDate retirementDay;

	public UtsuutsuCalc(LocalDate today, LocalDate birthday, LocalDate retirementDay) {
		this.today = today;
		this.birthday = birthday;
		this.retirementDay = retirementDay;
	}

	/**
	 * 現在から定年までの働く日数を取得する
	 */
	public void calculate() {

		// 現在年から定年の年までの休日を取得
		Map<Integer, AJD[]> holidayMap = getHoliday(this.today.getYear(), this.retirementDay.getYear());

		// 加算
		LocalDate nextDate = null;
		int addDay = 0;
		// 勤務日をカウントする
		int dayCount = 0;

		while (true) {
			nextDate = LocalDate.of(this.today.plusDays(addDay).getYear(), this.today.plusDays(addDay).getMonthValue(),
					this.today.plusDays(addDay).getDayOfMonth());

			// 定年日になったら終了
			if (nextDate.equals(retirementDay)) {
				break;
			}

			// 勤務日？
			if (isBusinessDay(nextDate, holidayMap)) {
				dayCount++;
			}
			addDay++;
		}
		// あなたの残り勤務日数
		System.out.println("あなたの勤務日は" + dayCount);
	}

	private boolean isBusinessDay(LocalDate targetDate, Map<Integer, AJD[]> holidayMap) {
		// 土日の場合
		if (isWeekEnd(targetDate)) {
			return false;
		}
		// 祝日の場合
		if (isHoliday(targetDate, holidayMap)) {
			return false;
		}

		return true;
	}

	/**
	 *
	 * 祝日判定<br/>
	 * 対象日付が祝日マップに存在するかどうかを判定する。<br/>
	 *
	 * @param targetDate
	 *            対象日付
	 * @param holidayMap
	 *            祝日マップ
	 * @return 祝日：true、祝日でない：false
	 */
	private boolean isHoliday(LocalDate targetDate, Map<Integer, AJD[]> holidayMap) {
		AJD[] targetHolidayArray = holidayMap.get(targetDate.getYear());
		try {
			for (AJD holiday : targetHolidayArray) {
				if (targetDate.equals(LocalDate.of(holiday.getYear(), holiday.getMonth(), holiday.getDay()))) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// 土日かどうかを判定
	private boolean isWeekEnd(LocalDate targetDate) {
		return targetDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault()).equals("土")
				|| targetDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault()).equals("日");
	}

	/**
	 *
	 * 祝日取得<br/>
	 * fromYear から toYear までの祝日マップを返却する。<br/>
	 *
	 * @param fromYear
	 *            開始年
	 * @param toYear
	 *            終了年
	 * @return 祝日マップ
	 */
	private Map<Integer, AJD[]> getHoliday(int fromYear, int toYear) {
		Map<Integer, AJD[]> holidayMap = new HashMap<>();

		try {
			while (true) {
				holidayMap.put(fromYear, Holiday.getHoliday(fromYear));
				if (fromYear == toYear) {
					break;
				}
				fromYear++;
			}
		} catch (AJDException e) {
			e.printStackTrace();
		}

		return holidayMap;
	}

}
