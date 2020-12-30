package com.algorithm.class_02.Dec_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_4153_Á÷°¢»ï°¢Çü {
	private static long a, b, c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());
			
			if (a == 0) {
				break;
			}
			
			long tmp = Math.max(Math.max(a, b), c);
			boolean chk = false;
			if (tmp == a) {
				chk = (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) ? true : false;
			} else if (tmp == b) {
				chk = (Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)) ? true : false;
			} else {
				chk = (Math.pow(c, 2) == Math.pow(b, 2) + Math.pow(a, 2)) ? true : false;
			}
			
			System.out.println(chk == true ? "right" : "wrong");
		}
		
	}	// end of main
}	// end of class












