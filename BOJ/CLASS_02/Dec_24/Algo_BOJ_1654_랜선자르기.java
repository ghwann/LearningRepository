package com.algorithm.class_02.Dec_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1654_랜선자르기 {
	private static int k, n;
	private static long max, max_wire;
	private static long[] wire;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		wire = new long[k];
		
		for (int i = 0; i < k; i++) {
			wire[i] = Long.parseLong(br.readLine());
			max_wire = (max_wire < wire[i] ? wire[i] : max_wire);
		}
		
		long low = 1, high = max_wire, mid = 0;
		int res;
		while (low <= high) {
			mid = (low + high) / 2;
			res = 0;
			
			for (int i = 0; i < k; i++) {
				res += wire[i] / mid;
			}
			
			if (res >= n) {
				low = mid + 1;
				max = (max < mid ? mid : max);
			} else {
				high = mid - 1;
			}
		}	// end of while loop
		
		System.out.println(max);
	}	// end of main
}	// end of class





















