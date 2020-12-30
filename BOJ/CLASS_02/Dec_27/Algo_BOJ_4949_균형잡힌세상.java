package com.algorithm.class_02.Dec_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algo_BOJ_4949_±ÕÇüÀâÈù¼¼»ó {
	private static Stack<Character> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		while (true) {
			str = br.readLine();
			stack = new Stack<Character>();
			
			if (".".equals(str)) {
				break;
			}
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '(' || ch == '[') {
					stack.push(ch);
				} else if (ch == ')' || ch == ']') {
					if (stack.isEmpty() || (ch == ')' && stack.peek() != '(') || (ch == ']' 
							&& stack.peek() != '[')) {
						stack.push(ch);
						break;
					}
					stack.pop();
				}
			}
			
			if (!stack.isEmpty()) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
	}	// end of main
}	// end of class













