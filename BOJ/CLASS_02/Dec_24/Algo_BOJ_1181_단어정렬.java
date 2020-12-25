package com.algorithm.class_02.Dec_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Algo_BOJ_1181_단어정렬 {
	private static int N;
	private static String[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 길이가 같으면 사전순
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				// 길이가 다르면 길이순
				return o1.length() - o2.length();
			}
		});
		
		for (int i = 0; i < N; i++) {
			if (i+1 != N) {
				if (arr[i].equals(arr[i+1])) continue;
			}
			sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class














