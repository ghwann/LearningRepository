package com.algorithm.class_02.Dec_26;

import java.util.Scanner;

public class Algo_BOJ_2231_������ {
	public static boolean create(int x, int n) { // �����ڸ� ã�� �޼ҵ�
		int result = x;
		int temp = x;
		while (temp != 0) { // ���޵� ������ ���� �� �ִ� ����� ã�� ���� ex)2�� ���� �� ���
							// result�� 4�� �ǹǷ� 2�� 4�� ������
			result += temp % 10;
			temp /= 10;
		}

		if (result == n) { // �̷��� ������� ������ �Է¹��� ������ ���ٸ�
			return true; // �����ڰ� �����ϴ� ��.
		} else {
			return false;
		} // �׷��� �ʴٸ� �����ڰ� �������� �ʴ� ��

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 1; i < 1000000; i++) { // n�� ������ŭ �ݺ�
			if (create(i, n)) { // �����ڰ� �����Ѵٸ�,
				System.out.println(i); // i���� ���, 1���� ���ϱ� ������ �ڿ����� �ּҰ��� ã������.
				return;// ���α׷� ����
			}
		}
		System.out.println(0);// ������ ��ε��Ƶ� ã�� ���ϸ� 0�� ���
	}

}
