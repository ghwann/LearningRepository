package com.ssafy.algo.lecture.Dec.twentytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo_BOJ_2447_별찍기_10 {
	private static int N;
	private static char[][] map;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}
		
		drawStar(N, 0, 0);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}	// end of main

	private static void drawStar(int m, int x, int y) {
		if (m == 1) {
			map[x][y] = '*';
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				drawStar(m/3, x+m/3*i, y+m/3*j);
			}
		}
	}
}	// end of class

















