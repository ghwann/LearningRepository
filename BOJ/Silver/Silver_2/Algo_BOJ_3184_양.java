import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_BOJ_3184_양 {
	private static int R, C, sheepCnt, wolvesCnt;
	private static char[][] map;
	private static boolean[][] checked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		checked = new boolean[R][C];
		
		String str = "";
		for (int i = 0; i < R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!checked[i][j] && map[i][j] != '#') {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(sheepCnt + " " + wolvesCnt);
	}	// end of main

	// 00 01 02
	// 10 11 12
	// 20 21 22
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static void bfs(int i, int j) {
		int sCnt = 0;
		int wCnt = 0;
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {i, j});
		checked[i][j] = true;
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			if(map[r][c]=='o')sCnt++;
			else if(map[r][c]=='v') wCnt++;
			
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if (0 <= nr && nr < R && 0 <= nc && nc < C && !checked[nr][nc] && map[nr][nc] != '#') {
					q.offer(new int[] {nr, nc});
					checked[nr][nc] = true;
				}
			}
			
		}	// end of while loop
		
		if (sCnt > wCnt) {
			sheepCnt += sCnt;
		} else {
			wolvesCnt += wCnt;
		}
	}
}	// end of class
