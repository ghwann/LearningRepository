package com.algorithm.class_02.Dec_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_10250_ACMÈ£ÅÚ {
	private static int T, H, W, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			String ans = "";
			
			if (N%H == 0) {
				int tmp = N/H;
				
				if (tmp < 10) {
					ans = H + "0" + tmp;
				} else {
					ans = H + "" + tmp;
				}
			} else {
				int tmp = N/H+1;
				
				if (tmp < 10) {
					ans = N%H + "0" + tmp;
				} else {
					ans = N%H + "" + tmp;
				}
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class










