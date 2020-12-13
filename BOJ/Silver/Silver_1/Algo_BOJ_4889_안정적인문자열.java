package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algo_BOJ_4889_안정적인문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<Character>();
		
		int index = 1;
		while (true) {
			String str = br.readLine();
			if (str.contains("-")) {
				break;
			}
			
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '{') {
					s.push(ch);
				} else {
					if (s.isEmpty()) {
						cnt++;
						s.push('{');
					} else {
						s.pop();
					}
				}
			}	// end of for loop
			
			cnt += s.size()/2;
			sb.append(index + ". " + cnt + '\n');
			s.clear();
			index++;
		}	// end of while loop
		
		System.out.println(sb);
	}	// end of main
}	// end of class
