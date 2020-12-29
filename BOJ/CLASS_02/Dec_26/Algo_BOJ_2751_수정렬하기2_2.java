package com.algorithm.class_02.Dec_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_2751_수정렬하기2_2 {
	private static int N;
	private static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		check = new boolean[2000001];
		
		for (int i = 0; i < N; i++) {
			check[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		
		for (int i = 0; i < check.length; i++) {
			if (!check[i]) continue;
			
			sb.append(i - 1000000).append('\n');
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class


















