package com.algorithm.class_02.Dec_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_1260_DFS와BFS_인접행렬 {
	private static int N, M, V;
	private static int[][] node;
	private static int[] check;
	private static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		node = new int[N+1][N+1];
		check = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node[a][b] = 1;
			node[b][a] = 1;
		}
		
		dfs(V);
		Arrays.fill(check, 0);
		System.out.println();
		bfs(V);
	}	// end of main

	private static void dfs(int x) {
		if (check[x] == 1) return;
		
		check[x] = 1;
		System.out.print(x + " ");
		
		for (int i = 1; i < node.length; i++) {
			if (node[x][i] == 1) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int x) {
		q = new LinkedList<>();
		q.offer(x);
		check[x] = 1;
		
		while (!q.isEmpty()) {
			x = q.poll();
			System.out.print(x + " ");
			
			for (int i = 1; i < node.length; i++) {
				if (check[i] != 1 && node[x][i] == 1) {
					q.offer(i);
					check[i] = 1;
				}
			}
		}
	}
}	// end of class















