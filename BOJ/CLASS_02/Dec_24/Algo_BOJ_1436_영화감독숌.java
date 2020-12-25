package com.algorithm.class_02.Dec_24;

import java.util.Scanner;

public class Algo_BOJ_1436_¿µÈ­°¨µ¶¼ò {
	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int temp = 666;
		int cnt = 1;
		while (cnt < N) {
			temp++;
			
			if (String.valueOf(temp).contains("666")) {
				++cnt;
			}
		}
		
		System.out.println(temp);
	}	// end of main
}	// end of class










