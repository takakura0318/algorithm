package aoj0006;

import java.util.Scanner;

/*
 * 長方形の中に円が含まれるかを判定するプログラムを作成してください。次のように、長方
 * 形は左下の頂点を原点とし、右上の頂点の座標 (W,H)が与えられます。また、円はその
 * 中心の座標 (x,y) と半径 r で与えられます。
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int W = sc.nextInt();
		int H = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int r = sc.nextInt();

		if(y >= r && y <= H-r && x >=r && x <= W-r){
			System.out.printf("Yes\n");
		}else{
			System.out.printf("No\n");
		}
	}
}
