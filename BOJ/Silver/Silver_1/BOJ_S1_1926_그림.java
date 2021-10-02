package daily_algorithm.day01_210916;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_1926_그림 {
	private static int n, m, cnt, max;
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}	// end of main

	private static int[] arrX = {-1, 0, 1, 0};
	private static int[] arrY = {0, 1, 0, -1};
	private static void bfs(int x, int y) {
		q = new LinkedList<int[]>();
		q.offer(new int[]{x, y});
		visited[x][y] = true;
		
		int size = 1;
		while (!q.isEmpty()) {
			int[] k = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = k[0] + arrX[i];
				int nc = k[1] + arrY[i];
				
				if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc] && map[nr][nc] == 1) {
					q.offer(new int[]{nr, nc});
					visited[nr][nc] = true;
					size++;
				}
			}
			
		}	// end of while
		
		max = Math.max(max, size);
	}

}	// end of class
