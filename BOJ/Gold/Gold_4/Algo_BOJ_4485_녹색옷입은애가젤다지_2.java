import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * dfs 로 접근해보자 => 시간초과
 * 0,0 -> n-1,n-1
 * 
 * 최단거리 알고리즘 
 * 다익스트라 : 하나의 특정 시작정점에서 출발, 모든 정점까지의 최단거리를 구하는 알고리즘 (음이 아닌 가중치만 가능) 	O(n^2)
 * 벨만포드 : 하나의 특정 시작정점에서 출발, 모든 정점까지의 최단거리를 구하는 알고리즘 (다 가능함) 				O(n^2) 
 * 프로이드 워셜 : 모든 정점간 최단거리  															O(n^3)
 * 
 *  BFS => 방문 배열 대신, 지금까지의 최단거리를 기록하자
 */
public class Algo_BOJ_4485_녹색옷입은애가젤다지_2 {
	private static int[][] m = new int[125][125];
	private static int[][] memo = new int[125][125];
	private static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1;; testCase++) {
			int N = Integer.parseInt(br.readLine()); // (2 ≤ N ≤ 125)
			if (N == 0) break;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					m[i][j] = str.charAt(index) - '0';
					memo[i][j] = Integer.MAX_VALUE; // memo[i][j] = [0][0]~[i][j]의 최소값 저장,  최대값으로 초기화
				}
			}
			
//			Queue<int[]> q = new LinkedList<int[]>();
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() { // 140ms
				@Override
				public int compare(int[] a, int[] b) {
					return a[2] - b[2]; // 오름차순
				}
			});
			
			memo[0][0] = m[0][0];
			q.add(new int[] {0,0, memo[0][0]}); // 행, 열, [0][0]~[i][j]의 최소값
			while(q.size() > 0) {
				int[] data = q.poll(); // Q에서 꺼내기
				int r = data[0];
				int c = data[1];
				int cost = data[2]; // 큐에 저장시점의 [0][0]~[i][j]의 최소값
				if (memo[r][c] < cost) continue; // 이미 더 작은값으로 업데이트 된 상태라면, 200ms
				for (int i = 0; i < dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (0<=nr && nr<N && 0<=nc && nc<N && memo[nr][nc] > memo[r][c] + m[nr][nc]) { // 배열범위 체크, memo의 저장된 값보다 더 저렴하면 진입
						memo[nr][nc] = memo[r][c] + m[nr][nc];
						q.add(new int[] {nr, nc, memo[nr][nc]});
					}
				}
			}
			sb.append("Problem ").append(testCase).append(": ").append(memo[N-1][N-1]).append('\n');
		} // end of for testCase
		System.out.print(sb);
	} // end of main
} // end of class























