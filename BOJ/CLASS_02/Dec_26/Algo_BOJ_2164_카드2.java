package com.algorithm.class_02.Dec_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Algo_BOJ_2164_Ä«µå2 {
	private static int N;
	private static Queue<Integer> q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while (q.size() != 1) {
			q.poll();
			int tmp = q.poll();
			q.offer(tmp);
		}
		
		System.out.println(q.peek());
	}	// end of main
}	// end of class




















