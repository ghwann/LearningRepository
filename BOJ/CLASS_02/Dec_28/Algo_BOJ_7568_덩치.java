package com.algorithm.class_02.Dec_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_7568_µ¢Ä¡ {
	private static int N;
	private static int[] ranking;
	private static int[][] info;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		ranking = new int[N];
		info = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ranking[i] = 1;
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) {
					ranking[i]++;
				}
				System.out.println(i + "_" + j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(ranking[i]).append(' ');
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class













