package javakadai.blackjack.create_cpu_List;

public class Cpu01 {

	/** CPUの人数を1で初期化 */
	static int cpuNumber = 1;

	/** CPUの名前を宣言 */
	private String name;

	/**
	 * デフォルトコンストラクタ
	 */
	public Cpu01() {
		setName("CPU" + cpuNumber);
		cpuNumber++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
