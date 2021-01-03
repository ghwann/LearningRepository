package com.algorithm.class_03.Jan_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Algo_BOJ_1764_µË∫∏¿‚ {
	private static int N, M;
	private static Map<String, String> m;
	private static ArrayList<String> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		m = new HashMap<>();
		arr = new ArrayList<>();
		
		String str = "";
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			m.put(str, str);
		}
		
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			if (m.get(str) != null) {
				arr.add(m.get(str));
			}
		}
		
		Collections.sort(arr);

		sb.append(arr.size()).append('\n');
		for (String name : arr) {
			sb.append(name).append('\n');
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class

















