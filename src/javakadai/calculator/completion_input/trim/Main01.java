package javakadai.calculator.completion_input.trim;

/**
 * 文字列の空白埋め、コンマを無くすプログラム<br>
 * Input:7 7 7 7 , 7 Output:77777
 */
public class Main01 {

	public static void main(String[] args) {

		// 仮の値を指定する
		String input = "7 7 7 7 , 7";

		// 文字列のコンマを無くす
		input = input.replaceAll(",", "");
		// 文字列の空白を無くす
		input = input.replaceAll("\\s", "");
		// 文字列の末尾のスペースを無くす
		input = input.replace("$", "");

		System.out.println(input); // ★実行結果:77777

	}

}
