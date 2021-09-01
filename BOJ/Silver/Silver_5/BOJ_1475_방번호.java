package daily_algorithm.day01_210825;

import java.util.Scanner;

public class BOJ_1475_방번호 {
	private static String N;
	private static int max;
	private static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLine();
		arr = new int[10];
		max = 0;
		
		for (int i = 0; i < N.length(); i++) {
			int idx = N.charAt(i) - '0';
			if (idx == 9) {
				arr[6]++;
			} else {
				arr[idx]++;
			}
		}
		
		if (arr[6] % 2 == 0) {
			arr[6] /= 2;
		} else {
			arr[6] /= 2;
			arr[6] += 1;
		}
		
		for (Integer i : arr) {
			if (max < i) max = i;
		}
		
		System.out.println(max);
	}	// end of main

}	// end of class
