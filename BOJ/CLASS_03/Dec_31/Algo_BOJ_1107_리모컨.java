package com.algorithm.class_02.Dec_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1107_리모컨 {
	private static int N, M;
	private static boolean[] broken;	// 고장여부 확인 배열
	
	public static void main(String[] args) throws IOException {
		// 1. 이동하려고 하는 채널 N, 고장난 버튼의 개수 M, 고장난 버튼 배열에 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		broken = new boolean[10];
		
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		if (M != 0) {
			st = new StringTokenizer(br.readLine(), " ");
		}
		
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true; 
		}
		
		// 2. +, - 버튼으로만 채널 이동하는 횟수 변수 ans에 저장
		int ans = N - 100;
		if (ans < 0) {
			ans = -ans;
		}
		
		// 3. 0 ~ 100,000의 범위에서 각 자리의 숫자 고장 여부 확인하는 메서드 isPossible 생성(numbers[tmp%10] == true)
		for (int i = 0; i <= 1000000; i++) {
			int c = i;
			int len = isPossible(c);
			
			// 6.만약 return 값이 0보다 클 경우 len + Math.abs(N - i) 값이 정답이 됨
			if (len > 0) {
				int press = c - N;
				if (press < 0) {
					press = -press;
				}
				
				if (ans > len + press) {
					ans = len + press;
				}
			}
		}
		
		System.out.println(ans);
	}	// end of main

	private static int isPossible(int c) {
		// 4. 고장여부 확인과 동시에 고장 버튼이면 return 0; 
		if (c == 0) {
			if (broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		
		// 5. 고장 버튼이 아닐시에 해당 숫자 버튼을 누르는 길이를 세서 return len;
		int len = 0;
		while (c > 0) {
			if (broken[c%10]) {
				return 0;
			}
			
			len+=1;
			c /= 10;
		}
		
		return len;
	}
}	// end of class













