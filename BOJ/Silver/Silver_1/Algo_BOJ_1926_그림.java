import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_1926_그림 {
	private static int N, M, cnt, now_size, max_size;
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max_size);
	}	// end of main

	// 00 01 02
	// 10 11 12
	// 20 21 22
	private static int[] dr = {-1, 1, 0, 0};	// 상, 하, 좌, 우
	private static int[] dc = {0, 0, -1, 1};
	private static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<Pos>();
		Pos p = new Pos(r, c);
		q.offer(p);
		cnt++;
		now_size = 1;
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for (int i = 0; i < dc.length; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
					now_size++;
					q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		if (now_size > max_size) {
			max_size = now_size;
		}
	}
	
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}	// end of class
