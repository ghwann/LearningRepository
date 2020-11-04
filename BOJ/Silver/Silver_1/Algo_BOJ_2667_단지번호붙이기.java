package com.algo.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Algo_BOJ_2667_단지번호붙이기 {
	private static int N, ans, cnt;
	private static int[][] apt;
	private static boolean[][] visited;
	private static int[] totalApt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		apt = new int[N][N];
		visited = new boolean[N][N];
		totalApt = new int[314];
		
		String str = "";
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				apt[i][j] = str.charAt(j) - '0';
			}
		}
		
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && apt[i][j] == 1) {
					ans++;
					cnt = 1;
					bfs(i, j);
					totalApt[ans] = cnt;
				}
			}
		}
		
		System.out.println(ans);
		Arrays.sort(totalApt, 1, ans+1);
		for (int i = 1; i <= ans; i++) {
			System.out.println(totalApt[i]);
		}
	}	// end of main

	// 00 01 02
	// 10 11 12
	// 20 21 22
	private static int[] dr = {-1, 1, 0, 0};	// 상, 하, 좌, 우
	private static int[] dc = {0, 0, -1, 1};
	private static void bfs(int i, int j) {
		Queue<Loc> q = new LinkedList<Loc>();
		Loc l = new Loc(i, j);
		q.offer(l);
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			l = q.poll();
			int r = l.x;
			int c = l.y;
			
			for (int k = 0; k < dr.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && apt[nr][nc] == 1) {
					cnt++;
					q.offer(new Loc(nr, nc));
					visited[nr][nc] = true;
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











