package aoj0005;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ３つの整数を読み込み、それらを値が小さい順に並べて出力するプログラムを作成して下さい。
 */

public class Main {


	public static void main(String[] args) {
		
		/** 回答例➀ */
//		Scanner num = new Scanner(System.in);
//		
//		int[] foo = new int[3]; 
//		
//		foo[0] = num.nextInt();
//		foo[1] = num.nextInt();
//		foo[2] = num.nextInt();
//		
//		Arrays.sort(foo);
//		
//		System.out.println(foo[0]+" "+foo[1]+" "+foo[2]);
		
		
		/** 回答例➁ */
		int[] foo = new int[3];
		Scanner num = new Scanner(System.in);
		
		for (int i = 0; i < foo.length; i++) {
				
			foo[i] = num.nextInt();
				
		}
		
		Arrays.sort(foo);
		
		num.close();
		
		System.out.println(foo[0]+" "+foo[1]+" "+foo[2]);
		
		
	}
	
}
