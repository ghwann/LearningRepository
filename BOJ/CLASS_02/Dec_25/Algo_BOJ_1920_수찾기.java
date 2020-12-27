package com.algorithm.class_02.Dec_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_BOJ_1920_¼öÃ£±â {
	private static int N, M;
	private static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		input = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		int tmp;
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			tmp = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(input, tmp)).append('\n');
		}
		
		System.out.println(sb);
	}	// end of main

	private static int binarySearch(int[] arr, int tmp) {
		int start = 0, end = arr.length-1;
		
		while (start <= end) {
			int mid = (start+end)/2;
			
			if (arr[mid] > tmp) {
				end = mid - 1;
			} else if (arr[mid] < tmp) {
				start = mid + 1;
			} else {
				return 1;
			}
		}
		
		return 0;
	}
}	// end of class

















