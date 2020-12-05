package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Algo_BOJ_1021_회전하는큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> deq = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= N; i++) {
			deq.offer(i);
		}
		
		int cnt = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while (true) {
				int index = 0;
				Iterator<Integer> iter = deq.iterator(); 
				
				while (iter.hasNext()) {
					if (iter.next() == num) {
						break;
					}
					index++;
				}
				
				if (index == 0) {
					deq.pollFirst();
					break;
				} else if (index > deq.size()/2) {
					deq.offerFirst(deq.pollLast());
					cnt++;
				} else {
					deq.offerLast(deq.pollFirst());
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}	// end of main
}	// end of class













