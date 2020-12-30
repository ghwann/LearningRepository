package com.algorithm.class_02.Dec_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo_BOJ_10989_수정렬하기3 {
	private static int N;
	private static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		numbers = new int[10001];
		
		for (int i = 0; i < N; i++) {
			numbers[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 1; i <= 10000; i++) {
			if (numbers[i] == 0) continue;
			
			for (int j = 0; j < numbers[i]; j++) {
				sb.append(i).append('\n');
			}
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class









