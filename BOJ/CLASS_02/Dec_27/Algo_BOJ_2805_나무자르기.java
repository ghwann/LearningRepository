package com.algorithm.class_02.Dec_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_BOJ_2805_나무자르기 {
	private static int N, M;
	private static int[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		
		st =new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);
		
		long start = 0;
		long end = trees[N-1];
		long mid = 0;
		long res = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				long tmp = trees[i] - mid;
				if (tmp > 0) {
					sum += tmp; 
				}
			}
			
			if (sum >= M) {
				start = mid + 1;
				res = mid;
			} else {
				end = mid - 1;
			}
		}
		
//		while (start <= end) {
//			long mid = (start + end) / 2;
//			long sum = 0;
//			
//			for (int i = 0; i < N; i++) {
//				if (mid < trees[i]) {
//					sum += trees[i] - mid; 
//				}
//			}
//			
//			if (sum >= M) {
//				if (res < mid) {
//					res = mid;
//				}
//				start = mid + 1;
//			} else {
//				end = mid - 1;
//			}
//		}
		
		System.out.println(res);
	}	// end of main
}	// end of class





















