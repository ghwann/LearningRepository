import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
//2019-06-01
//BOJ 16236 아기상어
 
/*
 * 아기상어의 초기 크기 : 2
 * 자신보다 큰 물고기가 있는 칸은 지날 수 없다. 나머지 칸은 지날 수 있다.
 * 자신의 크기보다 작은 물고기만 먹을 수 있다. 
 * ==> 크기가 같은 물고기는 먹을수는 없지만, 지나갈 수는 있다.
 * 
 * 더 이상 먹을 수 있는 물고기가 공간에 없으면. 엄마 상어에게 도움을 요청한다.
 * 먹을수 있는 물고기가 1마리면 먹으러 간다.
 * 1마리보다 많으면,가장 가까운 물고기를 먹으러 간다 .
 *  지나야하는 칸의 개수의 최솟값.
 *  가까운 물고기가 많으면 : 가장위 -> 가장 왼쪽 
 *  이동과 동시에 물고기를 먹는다. 
 *  물고기를 먹으면, 그 칸은 빈칸이된다.
 *  
 *  자신의 크기와 같은 수의 물고기를 먹으면 크기가 1 증가.
 *  크기가 2인 아기 상어는 물고기를 2마리 먹으면 이됨.
 *  
 */
public class Main_16236_아기상어 {
    static int N, ans;
    static int[][] map;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int sy = -1, sx = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sy = i;
                    sx = j; // 아기상어 위치 
                }
            }
        } // input
        bfs(sy, sx);
        System.out.println(ans);
    }// end of main
    
    
    public static void bfs(int sy, int sx) {
        int sharksize = 2; //초기크기 
        int sharkeat = 0;
        Queue<pair> q = new LinkedList<>();
        ArrayList<pair> fish = new ArrayList<>();
        boolean[][] visit = new boolean[N][N];
        q.add(new pair(sy, sx)); // 아기상어의 초기위치
        visit[sy][sx]=true;
 
        int time = 0;
        while (!q.isEmpty()) {
            
            int qSize = q.size();
            int y=-1, x=-1;
            for (int s = 0; s < qSize; s++) { //1초 단위로 순회 
                
                pair p = q.poll();
                y = p.y;
                x = p.x;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
 
                    if (ny < 0 || ny > N - 1 || nx < 0 || nx > N - 1 || visit[ny][nx] || map[ny][nx]>sharksize)
                        continue;
                    
                    q.add(new pair(ny, nx)); //방문할 수 있는 모든 곳 (빈 곳, 상어 이하 크기의 물고기 )
                    visit[ny][nx] = true;
                    if(map[ny][nx]!=0 && map[ny][nx]<sharksize) { //그 중, 먹을 수 있는 물고기 
                        fish.add(new pair(ny,nx));
                    }
                }
            } // 1초
            time++;
            
            if(fish.size()!=0) { //먹을 물고기가 있다.
                Collections.sort(fish); //조건에 맞는 물고기 찾기. 
                pair meal = fish.get(0);
                fish.clear(); 
                sharkeat++;
                if(sharksize==sharkeat) {
                    sharksize++;
                    sharkeat=0;
                }
                
                map[sy][sx]=0; //이전 상어 위치 초기화 
                sy=meal.y;
                sx=meal.x; //상어 위치 변경 
                map[sy][sx] = 9; //이동후 상어의 위치 
                
                q.clear(); 
                q.add(meal); //이동 후 상어의 위치부터 다시 bfs 순회. 
                ans+=time; //****** 시간을 더해준다. ******
                time = 0; //시간 초기화 
                for(int i=0;i<N;i++) { //visit initialize
                    Arrays.fill(visit[i], false);
                }
                visit[meal.y][meal.x]=true;
            }
            
        } // end of while
    }// end of bfs
 
 
    static class pair implements Comparable<pair> {
        int y;
        int x;
 
        public pair(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
 
        @Override
        public int compareTo(pair o) {
            if (this.y == o.y) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
