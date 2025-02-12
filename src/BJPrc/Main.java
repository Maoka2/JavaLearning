package BJPrc;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] tcNum = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            tcNum[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tcNum[i]);
        }




        int[][] dp = new int[Math.max(2,max+1)][2];
        dp[0][0] = 1; // 0을 몇번 호출하는가
        dp[0][1] = 0; // 1을 몇번 호출하는가
        dp[1][0] = 0; // 앞에 인덱스 : 해당 숫자 , 뒤에 인덱스 : 0이면 0 호출횟수, 1이면 1호출횟수
        dp[1][1] = 1;
        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];


        }
        for (int i = 0; i < T; i++) {
            bw.write(dp[tcNum[i]][0] + " " + dp[tcNum[i]][1] + "\n");
        }


        bw.flush();
        br.close();
        bw.close();


    }
}