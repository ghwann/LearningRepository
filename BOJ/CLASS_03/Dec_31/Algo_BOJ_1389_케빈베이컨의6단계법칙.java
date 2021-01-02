package com.algorithm.class_02.Dec_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_1389_케빈베이컨의6단계법칙 {
	private static int N, M;
	private static int[] people;
	private static boolean[][] map; 
	private static boolean[] isChecked;
	private static Queue<Pos> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		people = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = true;
			map[b][a] = true;
		}
		
		int min = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 1; i < N+1; i++) {
			people[i] = bfs(i);
			
			if (people[i] < min) {
				min = people[i];
				ans = i;
			}
		}
		
		System.out.println(ans);
	}	// end of main

	private static int bfs(int start) {
		isChecked = new boolean[N+1];
		q = new LinkedList<>();
		q.offer(new Pos(start, 0));
		isChecked[start] = true;
		int score = 0;
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			int now = p.v;
			int weight = p.weight;
			score += weight;

			for (int i = 1; i < N+1; i++) {
				if (map[now][i] && !isChecked[i]) {
					isChecked[i] = true;
					q.offer(new Pos(i, weight+1));
				}
			}
		}
		
		return score;
	}
	
	static class Pos {
		int v;
		int weight;
		
		public Pos(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}
	}	
}	// end of class


















