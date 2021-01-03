package com.algorithm.class_03.Jan_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Algo_BOJ_1927_√÷º“»¸ {
	private static int N;
	private static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if (tmp == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(pq.peek()).append('\n');
					pq.poll();
				}
			} else {
				pq.offer(tmp);
			}
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class
