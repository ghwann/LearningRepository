package com.algorithm.class_02.Dec_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_2869_달팽이는올라가고싶다 {
	private static int A, B, V, days;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		days = (V - B) / (A - B);
		
		if ((V - B) % (A - B) != 0) {
			days++;
		}
		
		System.out.println(days);
	}	// end of main
}	// end of class
