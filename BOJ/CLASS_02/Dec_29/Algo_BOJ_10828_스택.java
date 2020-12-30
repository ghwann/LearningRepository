package com.algorithm.class_02.Dec_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algo_BOJ_10828_Ω∫≈√ {
	private static int N;
	private static Stack<Integer> s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		s = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			switch (command) {
				case "push":
					s.push(Integer.parseInt(st.nextToken()));
					break;
				case "top":
					if (s.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(s.peek()).append('\n');
					}
					break;
				case "pop":
					if (s.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(s.peek()).append('\n');
						s.pop();
					}
					break;
				case "size":
					sb.append(s.size()).append('\n');
					break;
				case "empty":
					if (s.isEmpty()) {
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












