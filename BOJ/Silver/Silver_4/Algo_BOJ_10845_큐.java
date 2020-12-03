package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_10845_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<Integer>();
		int lastIdx = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push":
				int a = Integer.parseInt(st.nextToken());
				lastIdx = a;
				q.offer(a);
				break;
			case "front":
				if (!q.isEmpty()) {
					sb.append(q.peek()).append('\n');
				} else {
					sb.append("-1").append('\n');
				}
				break;
			case "back":
				if (!q.isEmpty()) {
					sb.append(lastIdx).append('\n');
				} else {
					sb.append("-1").append('\n');
				}
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if (!q.isEmpty()) {
					sb.append("0").append('\n');
				} else {
					sb.append("1").append('\n');
				}
				break;
			case "pop":
				if (!q.isEmpty()) {
					sb.append(q.poll()).append('\n');
				} else {
					sb.append("-1").append('\n');
				}
				break;
			default:
				break;
			}
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class
