package com.algorithm.class_02.Dec_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_2003_수들의합2 {
	private static int N, M;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+2];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 1;
		int right = 1;
		long sum = arr[1];
		int ans = 0;
		
		while (left <= right && right < N+1) {
			if (sum < M) {
				right += 1;
				sum += arr[right];
			} else if (sum == M) {
				ans++;
				right += 1;
				sum += arr[right];
			} else if (sum > M) {
				sum -= arr[left];
				left++;
				
				if (left > right) {
					right = left;
					sum = arr[left];
				}
			}
		}
		
		System.out.println(ans);
	}	// end of main
}	// end of class










