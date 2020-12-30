package com.algorithm.class_02.Dec_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Algo_BOJ_10814_나이순정렬 {
	private static int N;
	private static String[][] info;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		info = new String[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String age = st.nextToken();
			String name = st.nextToken();
			info[i][0] = age;
			info[i][1] = name;
		}
		
		Arrays.sort(info, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
			}
		});
		
		for (int i = 0; i < info.length; i++) {
			sb.append(info[i][0]).append(' ').append(info[i][1]).append('\n');
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class















