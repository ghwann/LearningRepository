package com.algorithm.class_02.Dec_26;

import java.util.Scanner;

public class Algo_BOJ_2231_분해합 {
	public static boolean create(int x, int n) { // 생성자를 찾는 메소드
		int result = x;
		int temp = x;
		while (temp != 0) { // 전달된 정수가 만들 수 있는 결과를 찾는 과정 ex)2가 전달 될 경우
							// result가 4가 되므로 2는 4의 생성자
			result += temp % 10;
			temp /= 10;
		}

		if (result == n) { // 이렇게 만들어진 정수가 입력받은 정수와 같다면
			return true; // 생성자가 존재하는 것.
		} else {
			return false;
		} // 그렇지 않다면 생성자가 존재하지 않는 것

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 1; i < 1000000; i++) { // n의 범위만큼 반복
			if (create(i, n)) { // 생성자가 존재한다면,
				System.out.println(i); // i값을 출력, 1부터 비교하기 때문에 자연스레 최소값이 찾아진다.
				return;// 프로그램 종료
			}
		}
		System.out.println(0);// 범위를 모두돌아도 찾지 못하면 0을 출력
	}

}
