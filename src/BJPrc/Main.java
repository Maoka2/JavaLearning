package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int I;
    static int[][] chess;
    static int startX,startY, endX, endY;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            I = Integer.parseInt(br.readLine());
            chess = new int[I][I];
            visited = new boolean[I][I];
            String[] current = br.readLine().split(" ");
            startX = Integer.parseInt(current[0]);
            startY = Integer.parseInt(current[1]);

            String[] end = br.readLine().split(" ");
            endX = Integer.parseInt(end[0]);
            endY = Integer.parseInt(end[1]);

            bw.write(bfs(startX,startY,endX,endY) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    static int bfs(int startX, int startY, int endX, int endY){
        if(startX == endX && startY == endY){
            return 0;
        }

        int[] dx = {-1,-2,-2,-1,1,2,2,1}; // 그림 그 11시 방향부터 시계방향으로
        int[] dy = {-2,-1,1,2,2,1,-1,-2}; // 그림 그 11시 방향부터 시계방향으로
        int[][] count = new int[I][I];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX,startY});
        count[startX][startY] = 0;
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < dx.length; i++){
                int mx = cx + dx[i];
                int my = cy + dy[i];

                if(mx >= 0 && my >= 0 && mx < I && my < I){
                    if(!visited[mx][my]){
                        visited[mx][my] = true;
                        q.add(new int[]{mx,my});
                        count[mx][my] = count[cx][cy] + 1;

                        if(mx == endX && my == endY){
                            return count[mx][my];
                        }
                    }
                }
            }
        }
        return -1;
    }
}

