package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if(N == 0){
            bw.write("0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        int[] difficulty = new int[N];
        for(int i = 0; i < N; i++){
            difficulty[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(difficulty);
        int range = Math.round((float) (N * 15) / 100);
        int sum = 0;
        int member = N - range * 2;
        for(int i = range; i < N-range; i++){
            sum+= difficulty[i];
        }

        int ans = Math.round((float) sum / member);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

