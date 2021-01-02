package com.algorithm.class_02.Dec_31;

import java.io.IOException;
import java.util.Scanner;

public class Algo_BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// 입력받은 문자열을 '-'을 기준으로 스플릿
		String[] n = sc.next().split("-");
		
		// 최소값이 저장될 변수
		int sum = Integer.MAX_VALUE;
		
		// 스플릿된 문자열 배열
		for (int i = 0; i < n.length; i++) {
			int tmp = 0;
			
			// 또 다시 '+'를 기준으로 스플릿
			String[] cal = n[i].split("\\+");
			
			// 추촐된 정수들을 모두 더해줌
			for (int j = 0; j < cal.length; j++) {
				tmp += Integer.parseInt(cal[j]);
			}
			
			// 첫 문자라면
			if (sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum -= tmp;
			}
		}
		
		System.out.println(sum);
	}	// end of main
}	// end of class


















