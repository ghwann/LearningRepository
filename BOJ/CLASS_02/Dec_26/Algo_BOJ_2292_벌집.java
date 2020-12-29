package com.algorithm.class_02.Dec_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo_BOJ_2292_¹úÁý {
	private static int N, layer, num, totalNum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		layer = totalNum = 1;
		while (true) {
			if (N <= totalNum) {
				break;
			} else {
				num += 6;
				totalNum += num;
				layer++;
			}
		}
		
		System.out.println(layer);
	}	// end of main
}	// end of class
