package com.algorithm.class_02.Dec_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1929_소수구하기 {
	private static int M, N;
	private static boolean[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		numbers = new boolean[1000001];
		
		for (int i = 2; i < 1000001; i++) {
			numbers[i] = true;
		}
		
		for (int i = 2; i*i <= N; i++) {
			if (numbers[i]) {
				for (int j = i*i; j <= N; j+=i) {
					numbers[j] = false;
				}
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (numbers[i]) {
				sb.append(i).append('\n');
			}
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class





















