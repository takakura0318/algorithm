package aoj0024;

// �悭�킩��Ȃ�

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

		 while(true) {

			 int n=sc.nextInt();
			 int x=sc.nextInt();

			 if(n==0 && x==0) break;

			 int ans=0;

			 // 1回目のループで1～5を繰り返さす
			 for(int i=1;i<=n;i++) {

				 // 2回目のループで2～5を繰り返す
				 for(int j=i+1;j<=n;j++) {

					// 3回目のループで3～5を繰り返す
					 for(int k=j+1;k<=n;k++) {

						 if(i+j+k==x)ans++;

					 }

				 }
			 }

			 System.out.println("@" + ans);
		 }

		 sc.close();
	 }

}

