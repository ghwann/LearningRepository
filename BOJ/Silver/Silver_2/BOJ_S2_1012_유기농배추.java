package daily_algorithm.day01_210918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1012_유기농배추 {
	private static int T, M, N, K, cnt;
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			q = new LinkedList<>();
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[c][r] = 1;
			}
			
			for (int k = 0; k < N; k++) {
				for (int m = 0; m < M; m++) {
					if (map[k][m] == 1 && !visited[k][m]) {
						bfs(k, m);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}	// end of testCase
		
		System.out.println(sb);
	}	// end of main
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static void bfs(int k, int m) {
		q.offer(new int[] {k, m});
		visited[k][m] = true;
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

}	// end of class





















