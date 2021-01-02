package com.algorithm.class_02.Dec_31;

import java.util.Scanner;

public class Algo_BOJ_1463_1로만들기 {
	private static int N;
	private static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N+1];
		
		dp[1] = 0;
		for (int i = 2; i < N+1; i++) {
			dp[i] = dp[i-1] + 1;
			
			if (i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}
		
		System.out.println(dp[N]);
	}	// end of main
}	// end of class
