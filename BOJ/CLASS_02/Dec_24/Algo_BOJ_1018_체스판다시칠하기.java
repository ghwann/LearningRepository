package com.algorithm.class_02.Dec_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1018_체스판다시칠하기 {
	private static int N, M, cntW, cntB, min;
	private static int[][] mapW, mapB, arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mapW = new int[8][8];
		mapB = new int[8][8];
		arr = new int[N][M];
		
		int temp = 0;	// W : 0, B : 1
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				mapW[i][j] = temp;
				mapB[i][j] = temp^1;
				temp = temp^1;
				if (j == 7) {
					temp = temp^1;
				}
			}
		}
		
		String str = "";
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = (str.charAt(j) == 'W' ? 0 : 1); 
			}
		}
		
		int ans = 0;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				ans = diffCnt(i, j);
				if (min > ans) {
					min = ans;
				}
			}
		}
		
		System.out.println(min);
	}	// end of main

	private static int diffCnt(int i, int j) {
		cntW = 0;
		cntB = 0;
		for (int k = 0; k < 8; k++) {
			for (int r = 0; r < 8; r++) {
				if (arr[k+i][r+j] != mapW[k][r]) {
					cntW++;
				}
				if (arr[k+i][r+j] != mapB[k][r]) {
					cntB++;
				}
			}
		}
		
		return Math.min(cntW, cntB);
	}
}	// end of class










