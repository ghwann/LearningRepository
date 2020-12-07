package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algo_BOJ_2493_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Stack<int[]> s = new Stack<int[]>();
		for (int i = 1; i <= N; i++) {
			int a = Integer.parseInt(st.nextToken());
			while (!s.isEmpty()) {
				if (s.peek()[0] >= a) {
					sb.append(s.peek()[1] + " ");
					break;
				}
				s.pop();
			}
			
			if (s.isEmpty()) {
				sb.append("0 ");
			}
			
			s.push(new int[] {a, i});
		}
		
		System.out.println(sb);
	}	// end of main
	
//	static class tower {
//		long height;
//		int index;
//		
//		public tower(long height, int index) {
//			this.height = height;
//			this.index = index;
//		}
//	}
}	// end of class
