package com.algorithm.class_03.Jan_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Algo_BOJ_1620_나는야포켓몬마스터이다솜 {
	private static int N, M;
	private static Map<String, Integer> mapS;
	private static Map<Integer, String> mapI;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mapS = new HashMap<>();
		mapI = new HashMap<>();
		
		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			mapS.put(str, i+1);
			mapI.put(i+1, str);
		}
		
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			if (str.charAt(0) > '0' && str.charAt(0) <= '9') {
				sb.append(mapI.get(Integer.parseInt(str))).append('\n');
			} else {
				sb.append(mapS.get(str)).append('\n');
			}
		}
		
		System.out.println(sb);
	}	// end of main
}	// end of class













