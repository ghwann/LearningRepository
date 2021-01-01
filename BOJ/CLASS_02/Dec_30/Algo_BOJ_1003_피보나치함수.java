package com.algorithm.class_02.Dec_30;

import java.util.Scanner;

public class Algo_BOJ_1003_�Ǻ���ġ�Լ� {
	static int t, n;
	static int check[] = new int[41]; // �޸������̼� ����� ���� �� ��� ���� �迭
	static int dp[][]; // 0��1�� Ƚ���� ���� �� �迭

	static int fibonacci(int n) { // �������� �־��� �Ǻ���ġ ���� �޼ҵ带 �Ϻ� ����
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		if (check[n] != 0) { // �̹� �޸�Ǿ� �ִ� ���
			return check[n]; // �ش� �޸��� ������ ��ȯ
		} else { // �޸�Ǿ����� ���� ���
			// �޸� �� �ش� ���� ��ȯ
			return check[n] = fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt(); // �׽�Ʈ ���̽�
		dp = new int[41][2]; // 0�� 1�� ���� ���� �� �迭
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1; // n�� 0�� 1�� ���� �̸� ����

		for (int i = 0; i < t; i++) { // �׽�Ʈ ���̽� �ݺ�
			n = sc.nextInt();
			fibonacci(n); // n�� �Է¹޾� �Ǻ���ġ ����

			for (int j = 2; j <= n; j++) { // 0���� 1���� �̸� �����صξ����Ƿ� 2������ ����
				dp[j][0] = dp[j - 1][0] + dp[j - 2][0]; // ��ȭ��
				dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
			}

			System.out.println(dp[n][0] + " " + dp[n][1]); // n�� 0�� 1�� ���� ���
		}
	}	// end of main
}	// end of class
