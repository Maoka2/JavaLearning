package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rooms = br.readLine().split(" ");
        int N = Integer.parseInt(rooms[0]);
        int M = Integer.parseInt(rooms[1]); // 전체 방 개수

        // 0 -> 청소 아직 안됨 1 -> 청소 됨
        String[] rcd = br.readLine().split(" ");
        int r = Integer.parseInt(rcd[0]);
        int c = Integer.parseInt(rcd[1]);
        int d = Integer.parseInt(rcd[2]);
        // r,c -> 처음 위치, d -> 바라보는 방향 0~3 시계방향
        int[][] room = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(s[j]);
            }
        }

        int count = 0; // 일단 시작점은 청소안되있다하니까 청소헀다고 가정

        int[] dx = {-1, 0, 1, 0}; // 12 3 6 9
        int[] dy = {0, 1, 0, -1}; // 12 3 6 9

        int cx = r;
        int cy = c;

        while (true) {
            if (room[cx][cy] == 0) {
                room[cx][cy] = -1;
                count++;
            }

            boolean isPossible = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int mx = cx + dx[d];
                int my = cy + dy[d];

                if (room[mx][my] == 0) { // 돌면서 청소할 곳 찾으면
                    cx = mx;
                    cy = my;
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) { // 네 방향 다 청소가 되있으면?
                int back = (d + 2) % 4;
                int bx = cx + dx[back];
                int by = cy + dy[back];

                if (room[bx][by] == 1) {
                    break;
                }
                cx = bx;
                cy = by;
            }
        }
        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
