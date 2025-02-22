package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        char[][] bW = new char[N][M];

        for (int i = 0; i < N; i++) {
            String color = br.readLine();
            for (int j = 0; j < M; j++) {
                bW[i][j] = color.charAt(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int countB = 0;
                int countW = 0;

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        char current = bW[i + k][j + l];
                        // W일 때 -> 짝짝 -> W , 짝홀 -> B, 홀짝 -> B, 홀홀 -> W
                        // B일때 -> 짝짝 -> B, 짝홀 -> W 홀짝 -> W 홀홀 -> B
                        char temp1 = '0';
                        char temp2 = '0';

                        if ((k + l) % 2 == 0) { // 대충 내가 W,B인지에 따라
                            temp1 = 'W';
                            temp2 = 'B';
                        } else {
                            temp1 = 'B';
                            temp2 = 'W';
                        }

                        if (current != temp1) {
                            countW++;
                        }

                        if (current != temp2) {
                            countB++;
                        }
                    }
                }
                if (countW < min) {
                    min = countW;
                }
                if (countB < min) {
                    min = countB;
                }
            }
        }
        bw.write(min + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
