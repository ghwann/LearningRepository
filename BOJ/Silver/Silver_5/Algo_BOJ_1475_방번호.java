package com.algorithm.study.BOJ.week09;

import java.util.Scanner;

public class Algo_BOJ_1475_방번호 {
	private static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		numbers = new int[10];
		
		// 6과 9는 바꿔쓸 쑤 있으므로 9일 경우엔 6으로 처리
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - '0';
			numbers[index == 9 ? 6 : index]++;
		}
		
		int max = 0;
		for (int i = 0; i < 9; i++) {
			if (i == 6) {
				// 6과 9가 한 세트에 포함되므로 2로 나눈 몫에 나머지가 0이 아닐 경우는 한 세트가 더 필요한 경우이므로 1을 더
				numbers[i] = numbers[i] / 2 + (numbers[i] % 2 == 0 ? 0 : 1); 
			}
			
			if (numbers[i] >= max) {
				max = numbers[i];
			}
		}
		
		System.out.println(max);
	}	// end of main
}	// end of class
