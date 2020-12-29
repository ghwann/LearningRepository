package com.algorithm.class_02.Dec_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Algo_BOJ_2751_수정렬하기2 {
	private static int N;
	private static ArrayList<Integer> numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		numbers = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(numbers);
		
		for (Integer item : numbers) {
			sb.append(item).append('\n');
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class










