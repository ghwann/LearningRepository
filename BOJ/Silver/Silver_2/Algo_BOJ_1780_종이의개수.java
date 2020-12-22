package com.ssafy.algo.lecture.Dec.twentytwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1780_종이의개수 {
	private static int N;
	private static int[][] map;
	private static int[] cnt;	// -1, 0, 1의 개수 넣을 변수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = new int[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
		
		divideAndConquer(0, 0, N);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}	// end of main

	private static void divideAndConquer(int x, int y, int m) {
		// 같은 숫자라면 해당 수의 count를 1 증가
		if (isPossible(x, y, m)) {
			cnt[map[x][y]] += 1;
		} else {
			int size = m/3;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divideAndConquer(x+i*size, y+j*size, size);
				}
			}
		}
			
	}

	private static boolean isPossible(int x, int y, int m) {
		int t = map[x][y];
		
		for (int i = x; i < x + m; i++) {
			for (int j = y; j < y + m; j++) {
				if (t != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}	// end of class
