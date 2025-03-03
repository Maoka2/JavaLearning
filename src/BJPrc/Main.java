package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] xhdfh;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmk = br.readLine().split(" ");
        N = Integer.parseInt(nmk[0]);
        M = Integer.parseInt(nmk[1]);
        K = Integer.parseInt(nmk[2]);

        xhdfh = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            String[] rc = br.readLine().split(" ");
            int r = Integer.parseInt(rc[0]) - 1;
            int c = Integer.parseInt(rc[1]) - 1;

            xhdfh[r][c] = 1;
        }

        int max = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(xhdfh[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max,bfs(i,j));
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int count = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++){
                int mx = cx + dx[i];
                int my = cy + dy[i];

                if(mx >= 0 && my >= 0 && my < M && mx < N){
                    if(xhdfh[mx][my] == 1 && !visited[mx][my]){
                        count++;
                        visited[mx][my] = true;
                        q.add(new int[]{mx,my});
                    }
                }
            }
        }
        return count;
    }
}

