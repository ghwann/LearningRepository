package com.algorithm.class_02.Dec_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_11050_이항계수1 {
	private static int N, K, sum;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N];
		
		comb(0, 0);
		
		System.out.println(sum);
	}	// end of main

	private static void comb(int idx, int cnt) {
		if (cnt == K) {
			sum++;
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			comb(i, cnt+1);
			isSelected[i] = false;
		}
	}
}	// end of class









