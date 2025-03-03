package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static boolean[][] visited;
    static int[][] qocn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {


            String[] mnk = br.readLine().split(" ");

            M = Integer.parseInt(mnk[0]);
            N = Integer.parseInt(mnk[1]);
            K = Integer.parseInt(mnk[2]);

            qocn = new int[N][M];

            for (int i = 0; i < K; i++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);

                qocn[y][x] = 1;
            }

            visited = new boolean[N][M];
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(qocn[i][j] == 1  && ! visited[i][j]){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        q.add(new int[]{y,x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] node = q.poll();
            int cy = node[0];
            int cx = node[1];

            for(int i = 0; i < 4; i++){
                int mx = cx + dx[i];
                int my = cy + dy[i];

                if(mx >= 0 && my >= 0 && mx < M && my < N){
                    if(qocn[my][mx] == 1 && ! visited[my][mx]){
                           visited[my][mx] = true;
                        q.add(new int[]{my,mx});
                    }
                }
            }


        }

    }
}

