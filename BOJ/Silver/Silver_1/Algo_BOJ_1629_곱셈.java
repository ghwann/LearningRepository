package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		System.out.println(func(A, B, C));
	}	// end of main

	private static long func(long a, long b, long c) {
		if (b == 0) {
			return 1;
		}
		
		long value = func(a, b/2, c);
		value = value * value % c;
		
		if (b%2 == 0) {
			return value;
		} else {
			return a * value % c;
		}
	}
}	// end of class








