package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        visited = new boolean[100001];

        bw.write(bfs(N, K) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs(int N, int K) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        q.add(new int[]{N, count});
        visited[N] = true;

        if (N == K) {
            return 0;
        }
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            count = current[1];

            if (x == K) {
                return count;
            }

            int[] dx = {x * 2, x + 1, x - 1};

            for (int i = 0; i < dx.length; i++) {
                int next = dx[i];
                if (next >= 0 && next < 100001 && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}

