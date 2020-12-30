package com.algorithm.class_02.Dec_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Algo_BOJ_10866_µ¦ {
	private static int N;
	private static Deque<Integer> deq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		deq = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();

			switch (command) {
			case "push_front":
				deq.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deq.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (deq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deq.peekFirst()).append('\n');
					deq.pollFirst();
				}
				break;
			case "pop_back":
				if (deq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deq.peekLast()).append('\n');
					deq.pollLast();
				}
				break;
			case "front":
				if (deq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deq.peekFirst()).append('\n');
				}
				break;
			case "back":
				if (deq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deq.peekLast()).append('\n');
				}
				break;
			case "size":
				sb.append(deq.size()).append('\n');
				break;
			case "empty":
				if (deq.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			default:
				break;
			} // end of switch case
		} // end of for loop

		System.out.println(sb);
	} // end of main
} // end of class
