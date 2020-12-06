package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Algo_BOJ_1406_에디터_스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> lList = new Stack<Character>();
		Stack<Character> rList = new Stack<Character>();
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < str.length(); i++) {
			lList.push(str.charAt(i));
		}
		
		for (int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			
			switch (c) {
			case 'L':
				if (!lList.isEmpty()) {
					rList.push(lList.pop());
				}
				
				break;
			case 'D':
				if (!rList.isEmpty()) {
					lList.push(rList.pop());
				}
				
				break;
			case 'B':
				if (!lList.isEmpty()) {
					lList.pop();
				}
				
				break;
			case 'P':
				char t = command.charAt(2);
				lList.push(t);
				break;
			default:
				break;
			}	// end of switch
		}	// end of for loop
		
		while (!lList.isEmpty()) {
			rList.push(lList.pop());
		}
		
		while (!rList.isEmpty()) {
			bw.write(rList.pop());
		}
		
		bw.flush();
		bw.close();
	}	// end of main
}	// end of class














