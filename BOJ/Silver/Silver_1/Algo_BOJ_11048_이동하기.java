package com.algorithm.study.BOJ.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_11048_이동하기 {
	private static int N, M;
	private static int[][] map, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				dp[r][c] = Math.max(dp[r-1][c-1] + map[r][c], 
						Math.max(dp[r-1][c] + map[r][c], dp[r][c-1] + map[r][c]));
			}
		}
		
		System.out.println(dp[N][M]);
	}	// end of main
}	// end of class
