package com.algorithm.class_03.Jan_01;

import java.util.Scanner;

public class Algo_BOJ_1676_팩토리얼0의개수 {
	private static int N, cntTwo, cntFive;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 2; i <= N; i++) {
			int tmp = i;
			
			while (true) {
				if (tmp%2 == 0) {
					cntTwo++;
					tmp /= 2;
				} else if (tmp%5 == 0) {
					cntFive++;
					tmp /= 5;
				} else {
					break;
				}
			}
		}
		
		System.out.println(Math.min(cntTwo, cntFive));
	}	// end of main
}	// end of class

















