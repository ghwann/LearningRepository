package com.ssafy.algo.lecture.Dec.sixteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_15651_N과M_3 {
	private static int N, M;
	private static int[] numbers;
//	private static boolean[] isSelected;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		numbers = new int[10];
//		isSelected = new boolean[10];
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dfs(0);
		System.out.println(sb);
	}	// end of main

	private static void dfs(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
//			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
//			isSelected[i] = true;
			dfs(cnt+1);
//			isSelected[i] = false;
		}
	}
}	// end of class









