package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int[] coins = new int[N];
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int total = K;
        int count = 0;
        for(int i = N-1; i>= 0; i--){
            while(total >= coins[i]){
                count += total / coins[i];
                total = total % coins[i];
            }
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

