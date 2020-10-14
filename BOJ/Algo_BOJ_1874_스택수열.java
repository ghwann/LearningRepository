package com.algorithm.study.BOJ.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algo_BOJ_1874_스택수열 {
	private static int N;
	private static int[] input;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		Stack<Integer> s = new Stack<>();
		
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		int j = 1;
		for (int i = 1; i <= N; i++) {
			s.push(i);
			sb.append("+").append('\n');
			
			while (!s.isEmpty() && s.peek() == input[j]) {
				s.pop();
				sb.append("-").append('\n');
				j++;
			}
		}
		
		if (s.isEmpty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}	// end of main
}	// end of class














