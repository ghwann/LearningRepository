package com.algorithm.class_02.Dec_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo_BOJ_15829_Hashing {
	private static int L, M, R; 
	private static long sum, totalSum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		M = 1234567891;
		R = 31;
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a' + 1;
			sum += idx * pow(R, i);
		}
		
		totalSum = sum % M;
		
		System.out.println(totalSum);
	}	// end of main

	private static long pow(int a, int b) {
		return b == 0 ? 1 : a*pow(a, b-1)%M;
	}
}	// end of class

















