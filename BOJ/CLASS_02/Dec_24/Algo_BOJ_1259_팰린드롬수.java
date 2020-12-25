package com.algorithm.class_02.Dec_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo_BOJ_1259_ÆÓ¸°µå·Ò¼ö {
	private static int len;
	private static char[] arr, revArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String str = br.readLine();
			if ("0".equals(str)) {
				break;
			}
			
			len = str.length();
			arr = new char[len];
			revArr = new char[len];
			
			for (int i = 0; i < len; i++) {
				arr[i] = str.charAt(i);
			}
			
			for (int i = len-1, j = 0; i >= 0; i--, j++) {
				revArr[j] = arr[i];
			}
			
			boolean chk = true;
			for (int i = 0; i < len; i++) {
				if (arr[i] != revArr[i]) {
					chk = false;
					break;
				}
			}
			
			if (!chk) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
	}	// end of main
}	// end of class










