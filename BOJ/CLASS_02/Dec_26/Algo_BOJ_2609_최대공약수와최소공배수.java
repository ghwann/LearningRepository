package com.algorithm.class_02.Dec_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_2609_최대공약수와최소공배수 {
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int gcd = 1;	// 최대공약수
		int cm = 1;		// 최소공배수
		for (int i = 2; i <= Math.min(N, M); i++) {
			if (N % i == 0 && M % i == 0) {
				gcd = i;
			}
		}
		
		cm = (N/gcd) * (M/gcd);
		
		System.out.println(gcd);
		System.out.println(cm*gcd);
	}	// end of main
}	// end of class














