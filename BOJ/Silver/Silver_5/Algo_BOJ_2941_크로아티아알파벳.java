package com.algorithm.study.BOJ.week09;

import java.util.Scanner;

public class Algo_BOJ_2941_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj","s=", "z="};
		String s = sc.next();
		
		for (int i = 0; i < arr.length; i++) {
			s = s.replaceAll(arr[i], "a");
		}
		
		System.out.println(s.length());
	}	// end of main
}	// end of class
