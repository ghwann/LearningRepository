package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		for (int i = 1; ; i++) {
			if (q.isEmpty()) break;
			
			if (i % K == 0) {
				if (q.size() != 1) {
					sb.append(q.poll()).append(", ");
				} else {
					sb.append(q.poll()).append(">");;
				}
			} else {
				int a = q.poll();
				q.offer(a);
			}
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class






