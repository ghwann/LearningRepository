package com.ssafy.algo.lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class Main_백준_14500_테트로미노 {
	private static int maxSum = 0;
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 세로크기, 4 <= N,M <= 500
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " "); // 폭이 일정하지 않아서 쪼개야함
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 1 <= 값 <= 1000
			}
		}
        
        // 전체 맵의 각정점에서 출발하는 DFS 를 돌려보자
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j, 0, 0); // 행,열,단계,지금까지의 숫자합
				visited[i][j] = false; // 방문체크 원복
				findㅗ(i,j);
			}
		}
        System.out.println(maxSum);
    } // end of main
    /** dfs 로 탐색할 수 없는 도형, ㅏㅓㅗㅜ 도형 체크 */
    private static void findㅗ(int r, int c) {
    	if (r+1 < N && c+2 <M) {
    		int sum = map[r][c] + map[r][c+1] +map[r][c+2] + map[r+1][c+1]; // ㅜ
    		if (maxSum < sum) maxSum = sum;
    	}
    	if (r+2 < N && c+1 <M) {
    		int sum = map[r][c] +map[r+1][c] + map[r+2][c] + map[r+1][c+1]; // ㅏ
    		if (maxSum < sum) maxSum = sum;
    	}
    	if (0 <= r-1 && c+2 < M) {
    		int sum = map[r][c] +map[r][c+1] + map[r][c+2] + map[r-1][c+1]; // ㅗ
    		if (maxSum < sum) maxSum = sum;
    	}
    	if (0 <= r-1 && r+1 < N && c+1 <M) {
    		int sum = map[r][c] +map[r][c+1] + map[r-1][c+1] + map[r+1][c+1]; // ㅓ
    		if (maxSum < sum) maxSum = sum;
    	}
    }
    private static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    private static int[] dc = { 0, 0,-1, 1};
	/** r,c 위치에서 깊이가4인 테트로미노 블럭을 탐색하는 dfs, step:현재단계, sum:지금까지의 숫자합 */
	private static void dfs(int r, int c, int step, int sum) {
		if (step == 4) { // 종료파트
			if (maxSum < sum) maxSum = sum; // 최대값 갱신
			return;
		} 
		
		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) { // 배열의 범위 벗어나는지 체크, 미방문 체크
				visited[nr][nc] = true;
				dfs(nr, nc, step+1, sum + map[r][c]);
				visited[nr][nc] = false;
			}
		}
	}
} // end of class





























