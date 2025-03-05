package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] tomato;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        M = Integer.parseInt(nm[0]);
        N = Integer.parseInt(nm[1]);

        tomato = new int[N][M];
        visited = new boolean[N][M];


        boolean noTrash = true;
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(s[j]);
                if (tomato[i][j] == 0) {
                    noTrash = false;
                } else if (tomato[i][j] == 1) {
                    q.add(new int[]{i, j,0});
                    visited[i][j] = true;
                }
            }
        }

        if (noTrash) {
            bw.write("0\n");
            bw.flush();
            br.close();
            bw.close();
            return;
        }

        int ans = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    bw.write("-1\n");
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }

        bw.write(ans + "\n");


        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int min = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int day = current[2];

            min = Math.max(min,day);

            for (int i = 0; i < 4; i++) {
                int mx = cx + dx[i];
                int my = cy + dy[i];

                if (mx >= 0 && my >= 0 && mx < N && my < M) {
                    if (!visited[mx][my] && tomato[mx][my] == 0) {
                        visited[mx][my] = true;
                        tomato[mx][my] = 1;
                        q.add(new int[]{mx, my, day + 1});
                    }
                }

            }
        }
        return min;
    }
}