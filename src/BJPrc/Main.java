package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int K = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        long[] lines = new long[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }
        // 802 / ans  + 743 /ans + 457 / ans + 539 / ans -> 11 이 되게 하는 ans의 최대값

        //냅다 그냥 다 찾거나

        long left = 1;
        Arrays.sort(lines);
        long right = lines[K - 1];
        long temp = 0;
        while (left <= right) {
            int count = 0;
            long center = (left + right) / 2;

            for(int i = 0; i < K; i++){
                count += lines[i] / center;
            }

            if(count < N){
                // 덜 만들어졌으면 center 값이 작아져야
                right = center-1;
            }else{
                temp = center;
                left = center + 1;
            }
        }

        bw.write(temp + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
