package com.ssafy.algo.lecture.Dec.seventeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_6603_로또 {
	private static int K;
	private static int[] input, numbers;
	private static boolean[] isSelected;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			
			K = Integer.parseInt(st.nextToken());
			if (K == 0) {
				break;
			} else {
				numbers = new int[6];
				input = new int[K];
				isSelected = new boolean[K];
			}
			
			for (int i = 0; i < K; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			System.out.println(sb);
		}
	}	// end of main

	private static void dfs(int idx, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(numbers[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = idx; i < K; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			numbers[cnt] = input[i];
			dfs(i+1, cnt+1);
			isSelected[i] = false;
		}
	}
}	// end of class
