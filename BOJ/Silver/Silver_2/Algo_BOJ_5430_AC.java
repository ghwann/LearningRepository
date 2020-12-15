package com.ssafy.algo.lecture;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Algo_BOJ_5430_AC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			String p = sc.next();
			int n = sc.nextInt();
			
			String arrStr = sc.next();
			Deque<Integer> deq = new LinkedList<Integer>();
			for (String s : arrStr.substring(1, arrStr.length()-1).split(",")) {
				if (!s.equals("")) {
					deq.add(Integer.valueOf(s));
				}
			}
			
			System.out.println(ac(deq, p));
		}
		
	}	// end of main

	private static String ac(Deque<Integer> deq, String commands) {
		boolean reverse = false;
		
		for (char command : commands.toCharArray()) {
			if (command == 'R') {
				reverse = !reverse;
			} else {
				if (deq.size() == 0) {
					return "error";
				}
				
				if (reverse) {
					deq.pollLast();
				} else {
					deq.pollFirst();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder("[");
		while (!deq.isEmpty()) {
			sb.append(reverse ? deq.pollLast() : deq.pollFirst());
			if (deq.size() != 0) {
				sb.append(',');
			}
		}
		
		sb.append(']');
		return sb.toString();
	}
}	// end of class


