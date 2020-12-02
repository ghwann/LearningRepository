package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algo_BOJ_6198_옥상정원 {
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] building = new int[N];
		
		for (int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(process(building));
	}	// end of main

	private static long process(int[] building) {
		long res = 0;
		Stack<Integer> s = new Stack<Integer>();
		s.push(building[0]);
		
		for (int i = 1; i < N; i++) {
			if (s.peek() > building[i]) {
				s.push(building[i]);
				res += s.size() - 1;
			} else {
				while (!s.isEmpty() && building[i] >= s.peek()) {
					s.pop();
				}
				s.push(building[i]);
				res += s.size() - 1;
			}
		}
		
		return res;
	}
}	// end of class
