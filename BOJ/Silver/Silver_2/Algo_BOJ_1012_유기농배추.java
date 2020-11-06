package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_1012_유기농배추 {
	private static int T, M, N, K, ans;		// T:테스트케이스, M:가로길이, N:세로길이, K:배추위치 개수, ans:필요한 지렁이 마리 수
	private static int[][] map;
	private static boolean[][] checked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			checked = new boolean[N][M];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[c][r] = 1;
			}
			
			ans = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (!checked[j][k] && map[j][k] == 1) {
						ans++;
						bfs(j, k);
					}
				}
			}
			
			System.out.println(ans);
		}
	}	// end of main

	// 00 01 02
	// 10 11 12
	// 20 21 22
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<Loc>();
		Loc l = new Loc(x, y);
		q.offer(l);
		checked[x][y] = true;
		
		while (!q.isEmpty()) {
			l = q.poll();
			int r = l.x;
			int c = l.y;
			
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !checked[nr][nc] && map[nr][nc] == 1) {
					q.offer(new Loc(nr, nc));
					checked[nr][nc] = true;
				}
			}
		}
	}
	
	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}	// end of class
