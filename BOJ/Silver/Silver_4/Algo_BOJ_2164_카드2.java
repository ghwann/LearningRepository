package com.ssafy.algo.lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_BOJ_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while (q.size() > 1) {
			q.poll();
			int a = q.poll();
			q.offer(a);
		}
		
		System.out.println(q.peek());
	}	// end of main
}	// end of class
