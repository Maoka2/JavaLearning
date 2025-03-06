package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] candy;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        candy = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                candy[i][j] = s.charAt(j);
            }
        }
        int max = 0;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swapLR(i, j);
                max = Math.max(Math.max(max, getRMax(i)), Math.max(getCMax(j), getCMax(j + 1)));
                swapLR(i, j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swapUD(i, j);
                max = Math.max(Math.max(max, getCMax(j)), Math.max(getRMax(i), getRMax(i + 1)));
                swapUD(i, j);

            }
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void swapUD(int x, int y) {
        char temp = candy[x][y];
        candy[x][y] = candy[x + 1][y];
        candy[x + 1][y] = temp;
    }

    static void swapLR(int x, int y) {
        char temp = candy[x][y];
        candy[x][y] = candy[x][y + 1];
        candy[x][y + 1] = temp;
    }

    static int getCMax(int c) {
        int max = 0;
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (candy[i][c] == candy[i - 1][c]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        return Math.max(max, count);
    }

    static int getRMax(int r) {
        int max = 0;
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (candy[r][i] == candy[r][i - 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}