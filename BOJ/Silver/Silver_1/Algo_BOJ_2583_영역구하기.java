package com.ssafy.algo.lecture.Dec.ten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_2583_영역구하기 {
	private static int M, N, K, totCnt, nowSize;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<Integer> arr;
	private static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		arr = new ArrayList<>();
		q = new LinkedList<>();
		
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = 1;
				}
			}
		}	// end of while loop
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					bfs(i, j);
					totCnt++;
				}
			}
		}
		
		Collections.sort(arr);
		System.out.println(totCnt);
		for (Integer item : arr) {
			System.out.print(item + " ");
		}
	}	// end of main

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static void bfs(int i, int j) {
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		nowSize = 1;
		
		while (!q.isEmpty()) {
			int[] x = q.poll();
			int r = x[0];
			int c = x[1];
			
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0 && !visited[nr][nc]) {
					q.offer(new int[] {nr, nc});
					nowSize++;
					visited[nr][nc] = true;
				}
			}
		}
		
		arr.add(nowSize);
	}
}	// end of class













