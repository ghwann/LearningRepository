package com.algorithm.class_03.Jan_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_1697_¼û¹Ù²ÀÁú {
	private static int N, K;
	private static boolean[] visited;
	private static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		System.out.println(bfs());
	}	// end of main

	private static int[] dr = {-1, 1, 2};
	private static int bfs() {
		if (N == K) {
			return 0;
		}
		
		q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		visited[N] = true;
		
		while (!q.isEmpty()) {
			int[] k = q.poll();
			int r = k[0];
			int t = k[1];
			
			if (r == K) {
				return t;
			}
			
			for (int i = 0; i < 3; i++) {
				int nr;
				if (i == 2) {
					nr = 2*r;
				} else {
					nr = r + dr[i];
				}
				
				if (0 <= nr && nr < 100001 && !visited[nr]) {
					q.offer(new int[] {nr, t+1});
					visited[nr] = true;
				}
			}
		}	// end of while loop
		
		return 0;
	}
}	// end of class















