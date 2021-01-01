package com.algorithm.class_02.Dec_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_1012_¿Ø±‚≥ÛπË√ﬂ {
	private static int T, M, N, K, cnt;
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			cnt = 0;
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			for (int k = 0; k < M; k++) {
				for (int j = 0; j < N; j++) {
					if (map[k][j] == 1 && !visited[k][j]) {
						bfs(k, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}	// end of testCase
		
		System.out.println(sb);
	}	// end of main

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1 ,1};
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] k = q.poll();
			int r = k[0];
			int c = k[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (0 <= nr && nr < M && 0 <= nc && nc < N && map[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}	// end of class


















