package com.algorithm.class_02.Dec_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_BOJ_1107_������ {
	private static int N, M;
	private static boolean[] broken;	// ���忩�� Ȯ�� �迭
	
	public static void main(String[] args) throws IOException {
		// 1. �̵��Ϸ��� �ϴ� ä�� N, ���峭 ��ư�� ���� M, ���峭 ��ư �迭�� ����
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
		
		// 2. +, - ��ư���θ� ä�� �̵��ϴ� Ƚ�� ���� ans�� ����
		int ans = N - 100;
		if (ans < 0) {
			ans = -ans;
		}
		
		// 3. 0 ~ 100,000�� �������� �� �ڸ��� ���� ���� ���� Ȯ���ϴ� �޼��� isPossible ����(numbers[tmp%10] == true)
		for (int i = 0; i <= 1000000; i++) {
			int c = i;
			int len = isPossible(c);
			
			// 6.���� return ���� 0���� Ŭ ��� len + Math.abs(N - i) ���� ������ ��
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
		// 4. ���忩�� Ȯ�ΰ� ���ÿ� ���� ��ư�̸� return 0; 
		if (c == 0) {
			if (broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		
		// 5. ���� ��ư�� �ƴҽÿ� �ش� ���� ��ư�� ������ ���̸� ���� return len;
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













