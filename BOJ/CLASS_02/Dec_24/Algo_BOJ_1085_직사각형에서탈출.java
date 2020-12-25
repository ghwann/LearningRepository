package com.algorithm.class_02.Dec_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1085_직사각형에서탈출 {
	private static int x, y, w, h, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int m = 0, n = 0;
		
		if (h/2 < y) {
			m = h - y;
		} else {
			m = y;
		}
		
		if (w/2 < x) {
			n = w - x;
		} else {
			n = x;
		}
		
		if (m >= n) {
			System.out.println(n);
		} else {
			System.out.println(m);
		}
	}	// end of main
}	// end of class













