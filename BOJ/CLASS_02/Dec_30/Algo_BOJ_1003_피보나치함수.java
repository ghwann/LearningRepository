package com.algorithm.class_02.Dec_30;

import java.util.Scanner;

public class Algo_BOJ_1003_피보나치함수 {
	static int t, n;
	static int check[] = new int[41]; // 메모이제이션 기법을 위한 각 결과 저장 배열
	static int dp[][]; // 0과1의 횟수를 저장 할 배열

	static int fibonacci(int n) { // 문제에서 주어진 피보나치 수열 메소드를 일부 수정
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		if (check[n] != 0) { // 이미 메모되어 있는 경우
			return check[n]; // 해당 메모의 내용을 반환
		} else { // 메모되어있지 않은 경우
			// 메모 후 해당 값을 반환
			return check[n] = fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt(); // 테스트 케이스
		dp = new int[41][2]; // 0과 1의 수를 저장 할 배열
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1; // n이 0과 1인 경우는 미리 저장

		for (int i = 0; i < t; i++) { // 테스트 케이스 반복
			n = sc.nextInt();
			fibonacci(n); // n을 입력받아 피보나치 수행

			for (int j = 2; j <= n; j++) { // 0번과 1번은 미리 저장해두었으므로 2번부터 시작
				dp[j][0] = dp[j - 1][0] + dp[j - 2][0]; // 점화식
				dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
			}

			System.out.println(dp[n][0] + " " + dp[n][1]); // n의 0과 1의 수를 출력
		}
	}	// end of main
}	// end of class
