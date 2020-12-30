package com.algorithm.class_02.Dec_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_10845_ť {
	private static int N;
	private static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		
		int lastNum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			switch (command) {
				case "push":
					int tmp = Integer.parseInt(st.nextToken());
					q.offer(tmp);
					lastNum = tmp;
					break;
				case "front":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(q.peek()).append('\n');
					}
					break;
				case "back":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(lastNum).append('\n');
					}
					break;
				case "pop":
					if (q.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(q.peek()).append('\n');
						q.poll();
					}
					break;
				case "size":
					sb.append(q.size()).append('\n');
					break;
				case "empty":
					if (q.isEmpty()) {
						sb.append(1).append('\n');
					} else {
						sb.append(0).append('\n');
					}
					break;
				default:
					break;
			}	// end of switch case
		}	// end of for loop
		
		System.out.println(sb);
	}	// end of main
}	// end of class
