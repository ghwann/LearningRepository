package com.algorithm.study.BOJ.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1182_부분수열의합 {
	private static int N, S, cnt;
	private static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		powerSet(input, N, 0, 0);
		
		if (S == 0) {
			cnt--;
		}
		
		System.out.println(cnt);
	}	// end of main

	private static void powerSet(int[] input, int n, int index, int sum) {
		if (index == n) {
			if (sum == S) {
				cnt++;
			}
			return;
		}
		
        powerSet(input, n, index + 1, sum);
        powerSet(input, n, index + 1, sum + input[index]);
	}
}	// end of class