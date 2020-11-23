package aoj0021;

// くそムズイ。原理は0022を参照。
// 【実装方法】
// ➀ 3次元配列を宣言する
// ➁ ➀で作った配列の適切な場所に代入する
// ➂  表示に関する処理

import java.util.Scanner;
class Main{
    public static void main(String[] av){
    	
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	
	int[][][] data=new int[4][3][10];
		
	System.out.println("配列の初期値は" + data[1][1][1]);	// 配列は宣言しただけでも、初期値として0が勝手に代入されている。
	

	for(int i=0;i<n;i++){
	    int b=sc.nextInt();
	    int f=sc.nextInt();
	    int r=sc.nextInt();
	    int v=sc.nextInt();	    
	    
		// このfor文で3次元配列にアクセスして代入処理をしてる。
		//(例)1回目のループでdata[1-1][1-1][3-1] += [8]が行われる。つまりdata[0][0][2] += [8]が行われる。
		//(例)2回目のループでdata[3-1][2-1][2-1] += [8]が行われる。つまりdata[2][1][1] += [7]が行われる。
		//(例)3回目のループでdata[4-1][3-1][8-1] += [1]が行われる。つまりdata[3][2][7] += [1]が行われる。
		// 注意点:int型の配列に宣言時に勝手に0が代入される。
	    data[b-1][f-1][r-1]+=v;	    

	}
	
	for(int k=0;k<4;k++){
	for(int i=0;i<3;i++){
	    for(int j=0;j<10;j++){
		System.out.print(" "+data[k][i][j]);
	    }
	    System.out.println();
	}
	if(k!=3)
	System.out.println("####################");
	}
    
    }
}
