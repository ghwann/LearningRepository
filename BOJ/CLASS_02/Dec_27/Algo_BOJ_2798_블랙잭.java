package com.algorithm.class_02.Dec_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_BOJ_2798_∫Ì∑¢¿Ë {
	private static int N, M, max, ans;
	private static int[] input;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		isSelected = new boolean[N];
		max = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		comb(0, 0);
		
		System.out.println(ans);
	}	// end of main

	private static void comb(int idx, int cnt) {
		if (cnt == 3) {
			calc();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			comb(i, cnt+1);
			isSelected[i] = false;
		}
	}

	private static void calc() {
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				sum += input[i];
			}
		}
		
		if (sum <= M) {
			int tmp = Math.abs(sum - M);
			if (max >= tmp) {
				max = tmp;
				ans = sum;
			}
		}
	}
}	// end of class









