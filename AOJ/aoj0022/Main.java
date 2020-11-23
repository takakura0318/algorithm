package aoj0022;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][][] HW = new int[4][3][10]; 
			
			
			for(int i =0; i < 4; i++) {
				for(int j = 0; j < 3; j++) {
					for(int k = 0; k < 10; k++) {
						HW[i][j][k] = 0;
						HW[0][0][2] = 8;
						System.out.print(HW[i][j][k]);
					}

				}
				System.out.println();
			}
			
			System.out.println();
		
			

	}

}

