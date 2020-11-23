package javakadai.blackjack.create_cpu_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 入力された数だけCpuクラスを生成し、List<Cpu>に格納する処理
 */
public class Main01 {

	public static void main(String[] args) {

		// Cpuクラスを保持するリストを宣言
		List<Cpu01> cpus = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;

		// CPUの数を「1」「2」「3」のどれかか入力されるまで入力させる
		try {
			while (true) {
				System.out.println(String.format("%sの数を選びなさい(1～3で選ぶ)", "Cpu"));
				input = reader.readLine();
				// cpuの数が「1」「2」「3」のどれかが入力されているかチェックする。
				if (isCpuNum(input)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 入力されたCpuの数に応じてCPUを生成し、List<Cpu>に追加する
		for (int i = 0; i < Integer.parseInt(input); i++) {
			cpus.add(new Cpu01());
		}

		// 入力されたCpuの数だけインスタンスが生成されているかを確認する(テスト)
		for (Cpu01 cpu : cpus) {
			System.out.println(cpu.getName());
		}

	}

	private static boolean isCpuNum(String input) {
		// もしも入力された値が「1」「2」「3」のどれかだった場合はtrue
		if (input.equals("1") || input.equals("2") || input.equals("3"))
			return true;

		return false;
	}

}
