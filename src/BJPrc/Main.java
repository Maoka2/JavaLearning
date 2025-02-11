package BJPrc;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 3으로 나누는게 제일 빨리 줄어들잖음
        // 그다음에 2
        // 3번은 언제 할까? -> 1을 빼서 3으로 나눌수있게 할때 쓰면 좋을것같은데
        // 3으로 나눠지는지 어떻게 아냐? -> 각 자리 수 합이 3으로 나눠지면 3의 배수

        int[] minimum = new int[N+1];

        for(int i = 2; i <=N; i++){
            // 0, 1은 어차피 0이니까
            minimum[i] = minimum[i-1] +1; // 일단 기본설정은 나에서 -1하면 내 이전수 라는 접근

            if(i % 2 == 0){
                minimum[i] = Math.min(minimum[i] , minimum[i/2]+1);
            }

            if(i % 3 == 0){
                minimum[i] = Math.min(minimum[i] , minimum[i/3] +1);
            }
        }

        bw.write(minimum[N] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


}
