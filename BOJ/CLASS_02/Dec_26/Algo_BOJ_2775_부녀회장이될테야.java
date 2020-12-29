package com.algorithm.class_02.Dec_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo_BOJ_2775_부녀회장이될테야 {
	private static int T, k, n;
	private static long[][] apt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			apt = new long[16][15];
			
			for (int j = 1; j < 15; j++) {
				apt[0][j] = j;
			}
			
			for (int j = 1; j < 16; j++) {
				for (int k = 0; k < 15; k++) {
					apt[j][k] = aptSum(j, k);
				}
			}
			
			sb.append(apt[k][n]).append('\n');
		}
		
		System.out.println(sb);
	}	// end of main

	private static long aptSum(int floor, int room) {
		long total = 0;
		
		for (int i = 1; i <= room; i++) {
			total += apt[floor-1][i];
		}
		
		return total;
	}
}	// end of class




















