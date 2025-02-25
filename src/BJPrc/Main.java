package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());


            if(N <= 3){
                bw.write( "1\n");
                continue;
            }

            long[] dp = new long[N+1];

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;


            for(int j = 4; j <= N; j++){
                dp[j] = dp[j-2] + dp[j-3];
            }
            bw.write(dp[N] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

