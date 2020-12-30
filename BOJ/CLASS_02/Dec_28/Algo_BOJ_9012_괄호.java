package com.algorithm.class_02.Dec_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algo_BOJ_9012_°ýÈ£ {
	private static int TC;
	private static Stack<Character> s;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(br.readLine());
		
		String str;
		for (int i = 0; i < TC; i++) {
			s = new Stack<Character>();
			str = br.readLine();
			
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				
				if (ch == '(') {
					s.push(ch);
				} else if (ch == ')') {
					if (s.isEmpty() || s.peek() == ')') {
						s.push(ch);
						break;
					}
					s.pop();
				}
			}
			
			if (s.isEmpty()) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class










