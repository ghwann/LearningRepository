package daily_algorithm.day01_210830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {
	private static Queue<Integer> q;
	private static int N, K, turn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		q = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		while (!q.isEmpty()) {
			if (++turn % K == 0) {
				sb.append(q.peek());
				if (q.size() != 1) {
					sb.append(", ");
				}
				q.poll();
			} else {
				int a = q.poll();
				q.offer(a);
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}	// end of main

}	// end of class
