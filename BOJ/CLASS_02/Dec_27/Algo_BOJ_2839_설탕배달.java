package com.algorithm.class_02.Dec_27;

import java.util.Scanner;

public class Algo_BOJ_2839_¼³ÅÁ¹è´Þ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		
		if (n % 5 == 0) {
			cnt = n / 5;
			System.out.println(cnt);
			System.exit(0);
		}
		
		if (n % 3 == 0) {
			cnt = n / 3;
			if (min > cnt) {
				min = cnt;
			}
		}
		
		cnt = 0;
		while (n > 5) {
			cnt++;
			n -= 5;
			
			if (n % 3 == 0) {
				int res = cnt + n/3;
				if (min > res) {
					min = res;
				}
			}
		}
		
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		
		System.out.println(min);
	}	// end of main
}	// end of class







