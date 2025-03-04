package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] quad;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        quad = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                quad[i][j] = s.charAt(j) - '0';
            }
        }


        recur(0, 0, N);

        bw.flush();
        br.close();
        bw.close();
    }

    static void recur(int x, int y, int size) throws IOException {
        boolean isPossible = true;


        // 반복 조건
        int temp = quad[x][y];

        a:
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (temp != quad[i][j]) {
                    isPossible = false;
                    break a;
                }
            }
        }

        if (isPossible) {
            bw.write(String.valueOf(temp));
            return;
        }

        bw.write('(');

        recur(x, y, size / 2);
        recur(x, y + size / 2, size / 2);
        recur(x + size / 2, y, size / 2);
        recur(x + size / 2, y + size / 2, size / 2);

        bw.write(')');
    }
}