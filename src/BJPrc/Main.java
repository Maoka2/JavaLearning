package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] nums = new int[N];
        String[] number = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(number[i]);
        }

        int[] accumulation = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            accumulation[i] = accumulation[i - 1] + nums[i - 1];
            // 1, 1 +2 , 1 + 2 + 3, .... 1~3 ->
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            String[] range = br.readLine().split(" ");
            int initIdx = Integer.parseInt(range[0]);
            int finIdx = Integer.parseInt(range[1]);
            // 1 3 -> acc[3]; 2 4 -> 1~4 - 1
            int ans = accumulation[finIdx] - accumulation[initIdx-1];
            bw.write(ans + "\n");

        }


        bw.flush();
        bw.close();
        br.close();
    }
}

