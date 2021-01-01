package com.algorithm.class_02.Dec_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_11866_요세푸스문제0 {
	private static int N, K;
	private static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		sb.append('<');
		int cnt = 1;
		while (!q.isEmpty()) {
			if (cnt == K) {
				sb.append(q.peek());
				if (q.size() != 1) {
					sb.append(", ");
				}
				q.poll();
				cnt = 1;
			} else {
				int tmp = q.poll();
				q.offer(tmp);
				cnt++;
			}
		}
		sb.append('>');
		
		System.out.println(sb);
	}	// end of main
}	// end of class














