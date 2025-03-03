package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static int[] floors;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //F 총 층 S 현재층  G 스타트링크

        String[] s = br.readLine().split(" ");
        F = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        G = Integer.parseInt(s[2]);
        U = Integer.parseInt(s[3]);
        D = Integer.parseInt(s[4]);

        floors = new int[F + 1];
        visited = new boolean[F + 1];

        int result = bfs(S,G);

        if(result == -1){
            bw.write("use the stairs\n");
        } else{
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs(int S, int G) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        q.add(new int[]{S, count});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int floor = current[0];
            count = current[1];

            if (floor == G) {
                return count;
            }
            int[] move = {floor + U, floor - D};
            for (int i = 0; i < move.length; i++) {
                int next = move[i];

                if (next >= 1 && next <= F && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, count + 1});
                }
            }
        }
        return -1;
    }
}

