package com.algorithm.class_02.Dec_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_18111_마인크래프트 {
	private static int N, M, B, min, max, time, inven;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				int temp = map[i][j]; 
				if (max < temp) {
					max = temp;
				}
				if (min > temp) {
					min = temp;
				}
			}
		}
		
		int leastTime = Integer.MAX_VALUE;
		int height = -1;
		for (int h = min; h <= max; h++) {
			inven = B;
			time = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int temp = map[i][j]; 
					if (temp == h) continue;
					
					if (temp > h) {
						inven += temp - h;
						time += (temp - h)*2;
					} else if (temp < h) {
						inven -= h - temp;
						time += h - temp;
					}
				}	// end of for loop 3
			}	// end of for loop 2
			
			if (inven < 0) continue;
			
			if (leastTime >= time) {
				leastTime = time;
				height = h;
			}
			
		}	// end of for loop 1
		
		System.out.println(leastTime + " " + height);
	}	// end of main
}	// end of class











