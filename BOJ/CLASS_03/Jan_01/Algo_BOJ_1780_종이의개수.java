package com.algorithm.class_03.Jan_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1780_종이의개수 {
	private static int N;
	private static int[][] map;
	private static int[] cnt;	// -1, 0, 1의 개수 넣어줄 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cnt = new int[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
		
		divideAndConquer(0, 0, N);
		
		for (Integer item : cnt) {
			sb.append(item).append(' ');
		}
		System.out.println(sb);
	}	// end of main

	private static void divideAndConquer(int r, int c, int len) {
		if (isPossible(r, c, len)) {
			cnt[map[r][c]]++;
		} else {
			// 다르면 len을 3으로 나눠서 3으로 나눈거에 대한 첫 인덱스에 해당 되는 좌표로 재호출한다.
            // 0 ~ 8 의 len이 9였는데 만족이 안됐다면 len이 3이 되고 각 시작점 {0,0}, {0,3}, {0,6} 으로 다시 재호출한다.
            //                                                        {3,0}, {3,3}, {3,6}
            //                                                        {6,0}, {6,3}, {6,6}
            // 현재 좌표 + 새로운길이 * 0 or 1 or 2 -> 9로 나눈 새로운 좌표가 나온다.
			int newLen = len/3;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divideAndConquer(r+newLen*i, c+newLen*j, newLen);
				}
			}
		}
	}

	private static boolean isPossible(int r, int c, int len) {
		int temp = map[r][c];
		
		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (temp != map[i][j]) return false;
			}
		}
		
		return true;
	}
}	// end of class



