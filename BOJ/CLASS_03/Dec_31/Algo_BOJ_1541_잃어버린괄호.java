package com.algorithm.class_02.Dec_31;

import java.io.IOException;
import java.util.Scanner;

public class Algo_BOJ_1541_�Ҿ������ȣ {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// �Է¹��� ���ڿ��� '-'�� �������� ���ø�
		String[] n = sc.next().split("-");
		
		// �ּҰ��� ����� ����
		int sum = Integer.MAX_VALUE;
		
		// ���ø��� ���ڿ� �迭
		for (int i = 0; i < n.length; i++) {
			int tmp = 0;
			
			// �� �ٽ� '+'�� �������� ���ø�
			String[] cal = n[i].split("\\+");
			
			// ���͵� �������� ��� ������
			for (int j = 0; j < cal.length; j++) {
				tmp += Integer.parseInt(cal[j]);
			}
			
			// ù ���ڶ��
			if (sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum -= tmp;
			}
		}
		
		System.out.println(sum);
	}	// end of main
}	// end of class


















