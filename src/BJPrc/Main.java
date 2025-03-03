package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[][] squares;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] mnk = br.readLine().split(" ");
        M = Integer.parseInt(mnk[0]);
        N = Integer.parseInt(mnk[1]);
        K = Integer.parseInt(mnk[2]);
        squares = new int[M][N];
        visited = new boolean[M][N];
        for(int i = 0; i < K; i++){
            String[] s = br.readLine().split(" ");
            int startX = Integer.parseInt(s[0]);
            int startY = Integer.parseInt(s[1]);
            int endX = Integer.parseInt(s[2]);
            int endY = Integer.parseInt(s[3]);

            for(int j = startX; j < endX; j++){
                for(int k = startY; k < endY; k++){
                    squares[k][j] = 1;
                }
            }
        }

        int count = 0;

        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(squares[i][j] == 0 && !visited[i][j]){
                    l.add(bfs(i,j));
                    count++;
                }
            }
        }
        Collections.sort(l);

        bw.write(count + "\n");
        for(int i = 0; i < l.size(); i++){
            bw.write(l.get(i) + " ");
        }
        bw.write("\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int size = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++){
                int mx = cx + dx[i];
                int my = cy + dy[i];

                if(mx >= 0 && my >= 0 && mx < M && my < N){
                    if(squares[mx][my] == 0 && !visited[mx][my]){
                        visited[mx][my] = true;
                        q.add(new int[]{mx,my});
                        size++;
                    }
                }
            }

        }
        return size;
    }
}

