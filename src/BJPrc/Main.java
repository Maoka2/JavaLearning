package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] wh = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            wh[i][0] = Integer.parseInt(s[0]);
            wh[i][1] = Integer.parseInt(s[1]);
        }


        for (int i = 0; i < N; i++) {
            int k = 0;
            for (int j = 0; j < N; j++) {
                if (wh[i][0] < wh[j][0] && wh[i][1] < wh[j][1]) {
                    k++;
                }
            }
            bw.write((k+1) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
