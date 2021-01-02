package com.algorithm.class_02.Dec_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1074_Z {
	private static int N, r, c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(func(N, r, c));
	}	// end of main

	private static int func(int n, int x, int y) {
		if (n == 0) {
			return 0;
		}
		
		int half = 1 << (n-1);
		if (x < half && y < half) return func(n-1, x, y);
		if (x < half && y >= half) return half*half + func(n-1, x, y-half);
		if (x >= half && y < half) return 2*half*half + func(n-1, x-half, y);
		return 3*half*half + func(n-1, x-half, y-half);
	}
}	// end of class















