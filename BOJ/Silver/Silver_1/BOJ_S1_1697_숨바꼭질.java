package daily_algorithm.day01_210917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1697_숨바꼭질 {
	private static int N, K;
	private static char[] arr;
	private static int[] arrX = {-1, 1, 2};
	private static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new char[100001];
		q = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if (N == K) {
			System.out.println(0);
			return;
		}
		
		arr[N] = 'S';
		arr[K] = 'Y';
		q.offer(new int[] {N, 0});
		
		while (!q.isEmpty()) {
			int[] m = q.poll();
			int x = m[0];
			int t = m[1];
			
			for (int i = 0; i < 3; i++) {
				int nx = (i == 2 ? x * 2 : x + arrX[i]);
				
				if (0 <= nx && nx <= 100000 && arr[nx] == 'Y') {
					System.out.println(t + 1);
					return;
				}
				
				if (0 <= nx && nx <= 100000 && arr[nx] != 'S') {
					arr[nx] = 'S';
					q.offer(new int[] {nx, t+1});
				}
			}
		}
	}	// end of main

}	// end of class
