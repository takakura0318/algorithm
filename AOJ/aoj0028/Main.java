package aoj0028;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		int[] a = new int[128];
		int i;
		
		// Scanner��hasNext()���\�b�h�́u�����ŗ^����ꂽsc�̐��������Ȃ�܂�(�^����ꂽ���͂��Ȃ��Ȃ�܂�)���[�v���񂷂��Ƃ��ł���B�v
		while (sc.hasNext()) {
			
			// ���͂��ꂽ�������������ɕϊ����ĕϐ�str�ɑ������
			str = sc.nextLine().toLowerCase();
			
			// 0�`�ϐ�str�̕����������̃��[�v���񂷁B�Ⴆ�΁uThis is a pen.�v�����͂��ꂽ�ꍇ��0�`9�񃋁[�v����
			for (i = 0; i < str.length(); i++) {
				
				// CharAt()���\�b�h�́un�Ԗڂ̕����𔲂��o���v���\�b�h�ł���B
				// �Ⴆ�΁A���͂��ꂽ�uthis is a pen.�v�̃L�[�ɑΉ�����l�ɃC���N�������g����
				a[str.charAt(i)]++;
				
			}
		}
		
		// �A���t�@�x�b�g��'a'�`'z'�܂Ń��[�v����
		for (char ch = 'a'; ch <= 'z'; ch++) {
			
			System.out.println(ch + " : " + a[ch]);
			
		}
		sc.close();

	}
}
