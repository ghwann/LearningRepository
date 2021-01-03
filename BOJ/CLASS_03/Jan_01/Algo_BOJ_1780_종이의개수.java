package com.algorithm.class_03.Jan_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1780_�����ǰ��� {
	private static int N;
	private static int[][] map;
	private static int[] cnt;	// -1, 0, 1�� ���� �־��� �迭
	
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
			// �ٸ��� len�� 3���� ������ 3���� �����ſ� ���� ù �ε����� �ش� �Ǵ� ��ǥ�� ��ȣ���Ѵ�.
            // 0 ~ 8 �� len�� 9���µ� ������ �ȵƴٸ� len�� 3�� �ǰ� �� ������ {0,0}, {0,3}, {0,6} ���� �ٽ� ��ȣ���Ѵ�.
            //                                                        {3,0}, {3,3}, {3,6}
            //                                                        {6,0}, {6,3}, {6,6}
            // ���� ��ǥ + ���ο���� * 0 or 1 or 2 -> 9�� ���� ���ο� ��ǥ�� ���´�.
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



