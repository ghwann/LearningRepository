package com.algorithm.class_02.Dec_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Algo_BOJ_11651_좌표정렬하기2 {
	private static int N;
	private static int[][] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		numbers = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			numbers[i][0] = Integer.parseInt(st.nextToken());
			numbers[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return Integer.compare(o1[1], o2[1]);
			}
		});

		for (int i = 0; i < N; i++) {
			sb.append(numbers[i][0]).append(' ').append(numbers[i][1]).append('\n');
		}

		System.out.println(sb);
	} // end of main
} // end of class
