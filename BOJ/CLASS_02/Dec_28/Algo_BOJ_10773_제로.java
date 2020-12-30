package com.algorithm.class_02.Dec_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algo_BOJ_10773_Á¦·Î {
	private static int K, sum;
	private static Stack<Integer> s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		s = new Stack<>();
		
		for (int i = 0; i < K; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp != 0) {
				s.push(tmp);
			} else if (tmp == 0) {
				s.pop();
			}
		}
		
		for (Integer item : s) {
			sum += item;
		}
		
		System.out.println(sum);
	}	// end of main
}	// end of class















