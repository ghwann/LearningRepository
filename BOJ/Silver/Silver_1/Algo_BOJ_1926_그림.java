package com.algorithm.study.BOJ.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_1926 {
	private static int N;
	private static int M;
	private static int[][] canvas;
	private static boolean[][] visited;
	private static int max_size;
	private static int now_size;
	private static int cnt;
	private static int[] dr = {-1, 1, 0, 0};	// 상, 하, 좌, 우
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		canvas = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				canvas[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Loc> q = new LinkedList<Loc>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && canvas[i][j] == 1) {
					Loc l = new Loc(i, j);
					q.offer(l);
					cnt++;
					now_size = 1;
					visited[i][j] = true;
					
					while (!q.isEmpty()) {
						l = q.poll();
						int r = l.r;
						int c = l.c;
						
						for (int k = 0; k < dr.length; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							
							if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] 
								&& canvas[nr][nc] == 1) {
								now_size++;
								q.offer(new Loc(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
				}
				if (now_size > max_size) {
					max_size = now_size;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max_size);
	}	// end of main

	static class Loc {
		int r, c;
		
		public Loc() {
			
		}

		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}	// end of class














