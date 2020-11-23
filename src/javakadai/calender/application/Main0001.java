package javakadai.calender.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;

public class Main0001 {

	public static void main(String[] args) throws IOException {

		// 誕生日を入力する
		LocalDate birthday = pleaseEnterYourBirthday();

		// 誕生日と現在で年齢を算出
		LocalDate today = LocalDate.now();

		// 定年退職日を算出
		LocalDate retirementDay = getRetirementDay(birthday, today);

		// 定年日を表示する
		System.out.println("あなたの定年日は(LocalDate型)" + retirementDay);

		// 退職済みかをチェック
		if (areYouAlreadyRetired(today, retirementDay)) {
			System.out.println("あなたは既に退職済みです。");
		}

		// 本日が退職日かをチェックする
		if (willYouRetireToday(today, retirementDay)) {
			System.out.println("本日が退職日となります。");
		}

		// 鬱々カレンダーを実行
		UtsuutsuCalc utsuutsuCalc = new UtsuutsuCalc(today, birthday, retirementDay);
		utsuutsuCalc.calculate();

		// ハッピーカレンダーを実行
		HappyCalc happyCalc = new HappyCalc(today, birthday, retirementDay);
		happyCalc.calculate();
	}

	private static boolean willYouRetireToday(LocalDate today, LocalDate retirementDay) {
		// 今日退職予定の場合はおめでとう！
		if (ChronoUnit.DAYS.between(today, retirementDay) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 定年を超えているかをチェックする
	 */
	private static boolean areYouAlreadyRetired(LocalDate today, LocalDate retirementDay) {

		if (ChronoUnit.DAYS.between(today, retirementDay) < 0) {
			return true;
		}

		return false;
	}

	/**
	 *
	 * 定年退職日取得<br/>
	 * 誕生日と実行日から定年退職日を算出する。<br/>
	 *
	 * @param birthday
	 *            誕生日
	 * @param today
	 *            実行日
	 * @return 定年退職日
	 */
	private static LocalDate getRetirementDay(LocalDate birthday, LocalDate today) {

		// 4月~12生まれの場合は、変数「addYear」に66を代入する
		// 1月~3月生まれの場合は、変数「addYear」に65を代入する
		int addYear = getAddYear(birthday);
		// 定年退職日を返す
		return LocalDate.of(addYear, 3, 31);

	}

	/**
	 *
	 * 60歳までの加算年数取得<br/>
	 * 4月～12月生まれは +61年<br/>
	 * それ以外は +60年<br/>
	 *
	 * @param birthDay
	 *            誕生日
	 * @return 加算後の年
	 */
	private static int getAddYear(LocalDate birthday) {

		// もしも誕生月が４月~12月の間の場合(早生まれの場合)
		if (4 <= birthday.getMonthValue() && birthday.getMonthValue() <= 12) {
			return birthday.plusYears(66).getYear();
		}
		return birthday.plusYears(65).getYear();
	}

	/**
	 *
	 * 標準入力：誕生日を入力してください。<br/>
	 * 入力された誕生日文字列の妥当性チェックを行い、問題なければLocalDate型に変換して返却する。
	 *
	 * @return
	 *
	 * @return 誕生日（LocalDateクラス）
	 * @throws IOException
	 *             IOException
	 */
	private static LocalDate pleaseEnterYourBirthday() throws IOException {
		// 入力を促す
		System.out.print(String.format("Please enter %s.", "your birthday"));
		String input = null;
		String str = "(yyyy/MM/dd)形式で入力してください";
		while (true) {
			// ユーザから入力を受け取る
			input = getInput(str);

			// 日付の妥当性チェックを行う
			if (isCorrectDate(input)) {
				break;
			}
		}
		// 生年月日文字列をスラッシュ区切りで配列化
		String[] birthdayArray = input.split("/");

		// 生年月日を表示する
		System.out.println(String.format("あなたの生年月日は %d/%d/%d", Integer.parseInt(birthdayArray[0]),
				Integer.parseInt(birthdayArray[1]), Integer.parseInt(birthdayArray[2])));

		return LocalDate.of(Integer.parseInt(birthdayArray[0]), Integer.parseInt(birthdayArray[1]),
				Integer.parseInt(birthdayArray[2]));

	}

	/**
	 *
	 * 日付妥当性チェック<br/>
	 * 日付の妥当性を検証する。<br/>
	 *
	 * @param input
	 *            入力値
	 * @return 正しい日付：true、正しくない日付：false
	 */
	private static boolean isCorrectDate(String input) {

		// もしも何も入力されていない場合
		if (isEmpty(input)) {
			System.out.println("何も入力されていません");
			return false;
		}

		// 誕生日文字列をスラッシュ区切りで配列化
		String[] inputArray = input.split("/");

		// もしも「/」で区切られていない場合 && もしも年が4桁ではじまっていない ||「-」から始まっていない場合
		if (!isCorrectFormat(inputArray)) {
			System.out.println("誕生日を入力してください(yyyy/mm/dd形式)");
			return false;
		}

		// 月を先頭0埋めして yyyy/MM/dd 形式に戻す
		inputArray[1] = paddingZero(inputArray[1]);
		// 日を先頭0埋めして yyyy/MM/dd 形式に戻す
		inputArray[2] = paddingZero(inputArray[2]);
		// スプリットされた日付配列をスラッシュ区切り文字列に戻す。
		input = deSplit(inputArray);

		// 文字列 → DateTimeFormatter(日付をフォーマット) → LocalDateに変換
		// https://qiita.com/i_learnin/items/0e90036b2d7f664a249d
		// フォーマットを指定する。西暦はuuuuを指定する
		DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu/MM/dd")
				.withResolverStyle(ResolverStyle.STRICT);
		LocalDate inputDate = null;

		// 入力値(生年月日文字列)をLocalDate型に変換する
		try {
			inputDate = LocalDate.parse(input, df);
		} catch (DateTimeParseException e) {
			// 変換失敗→正しくない日付
			System.out.print("入力日付が正しくありません");
			return false;
		}

		// 入力された誕生日が未来日付の場合はエラー
		if (ChronoUnit.DAYS.between(inputDate, LocalDate.now()) < 0) {
			System.out.println("未来の日付が入力されています");
			return false;
		}

		// 正しい生年月日(日付)が入力されている場合はtrueを返す
		return true;
	}

	/**
	 *
	 * 日付デスプリット<br/>
	 * スプリットされた日付配列をスラッシュ区切り文字列に戻す。<br/>
	 *
	 * @param array
	 *            日付配列
	 * @return yyyy/MM/dd形式の日付文字列
	 */
	private static String deSplit(String[] inputArray) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(inputArray[0]);// 年
		stringBuilder.append("/");
		stringBuilder.append(inputArray[1]);// 月
		stringBuilder.append("/");
		stringBuilder.append(inputArray[2]);// 日
		return stringBuilder.toString();
	}

	/**
	 *
	 * 先頭"0"パディング<br/>
	 * 引数で渡された文字列に対してLPadする。<br/>
	 *
	 * @param target
	 *            対象文字列
	 * @return "0"埋め後の文字列
	 */
	private static String paddingZero(String target) {
		// 「月」もしくは「日」が2桁に満たない場合(つまり「%2」の場合)は先頭を0埋めする
		String paddingStr = String.format("%2s", target).replace(" ", "0");

		return paddingStr;
	}

	/**
	 *
	 * 日付形式チェック<br/>
	 * yyyy/MM/dd形式かどうか、年が正しく入力されているかを判定する。<br/>
	 *
	 * @param date
	 *            対象日付
	 * @return 正しい形式：true、正しくない形式：false
	 */
	private static boolean isCorrectFormat(String[] date) {

		// 前準備としてスラッシュ区切りで配列化している
		// もしもyyyy/mm/dd形式でない場合(つまり、文字列をスラッシュ区切りで配列化した結果の配列の長さが3でない場合は間違った値となる)
		if (date.length != 3)
			return false;

		// 年が4桁であるか、「-」から始まっていないか
		if (date[0].length() != 4 || date[0].startsWith("-")) {
			return false;
		}
		return true;
	}

	/**
	 *
	 * 何かしら入力されているかをチェックし、何も入力されていない場合はfalseを返す<br/>
	 *
	 * @param target
	 *            入力値
	 * @return 何も入力されていない：true、何か入力されている：false
	 */
	private static boolean isEmpty(String target) {

		return target.equals("") || target == null;
	}

	/**
	 *
	 * インプット（再表示向け）<br/>
	 * 標準入力。引数で渡された入力ヒント文字列を出力する。<br/>
	 *
	 * @param hint
	 *            入力ヒント文字列
	 * @return 入力値
	 * @throws IOException
	 *             IOException
	 */
	private static String getInput(String hint) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;

		System.out.println(hint);
		input = reader.readLine();

		return input;

	}

}
