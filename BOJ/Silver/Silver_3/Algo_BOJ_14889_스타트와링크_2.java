package com.ssafy.algo.lecture.Dec.nineteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_14889_스타트와링크_2 {
	private static int N, M, min;
	private static int[][] map;
	private static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = N/2;
		map = new int[N][N];
		isSelected = new boolean[N];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(min);
	}	// end of main

	private static void dfs(int idx, int cnt) {
		if (cnt == M) {
			makeTeamList();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			dfs(i+1, cnt+1);
			isSelected[i] = false;
		}
	}

	private static void makeTeamList() {
		int sumA = 0, sumB = 0;
		int idxA = 0, idxB = 0;
		int[] A = new int[M];
		int[] B = new int[M];
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				A[idxA++] = i;
			} else {
				B[idxB++] = i;
			}
		}
		
		sumA = sumTeamStat(A);
		sumB = sumTeamStat(B);
		
		int result = Math.abs(sumA - sumB);
		
		min = Math.min(result, min);
	}

	private static int sumTeamStat(int[] arr) {
		int result = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = i+1; j < M; j++) {
				result += map[arr[i]][arr[j]] + map[arr[j]][arr[i]];
			}
		}
		
		return result;
	}
}	// end of class













