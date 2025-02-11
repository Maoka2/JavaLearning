package BJPrc;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stepScore = new int[N+1];
        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            stepScore[i] = Integer.parseInt(s);
        }
        int[] sum = new int[N+1];

        if(N==1){
            bw.write(stepScore[1] + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        sum[1] = stepScore[1];

        sum[2] = stepScore[1] + stepScore[2];
        if(N == 2){
            bw.write(sum[2] + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        sum[3] = Math.max(stepScore[1],stepScore[2]) + stepScore[3];
        // 마지막 계단은 무적권 밟아야 하니까
        // case1. N-2번째 계단에서 2개 연속으로 밟기
        // case2. N-1번째 계단에서 그냥 하나 밟고 끝

        for(int i = 4; i <=N; i++){
            sum[i] = Math.max(sum[i-2],sum[i-3]+stepScore[i-1]) + stepScore[i];
        }

        bw.write(sum[N] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


}
