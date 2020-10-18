package com.algorithm.study.BOJ.week09;

import java.util.Scanner;

public class Algo_BOJ_1475_방번호 {
	private static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		numbers = new int[10];
		
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - '0';
			numbers[index == 9 ? 6 : index]++;
		}
		
		int max = 0;
		for (int i = 0; i < 9; i++) {
			if (i == 6) {
				numbers[i] = numbers[i] / 2 + (numbers[i] % 2 == 0 ? 0 : 1); 
			}
			
			if (numbers[i] >= max) {
				max = numbers[i];
			}
		}
		
		System.out.println(max);
	}	// end of main
}	// end of class
