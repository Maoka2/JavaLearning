package BJPrc;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){

            int N = Integer.parseInt(br.readLine());

            // 1 -> (1) -> 1
            // 2 -> (1,1) , (2) -> 2
            // 3 -> (1,1,1) , (1,2) , (2,1), (3) -> 4
            // 4 -> (1,1,1,1),(1,1,2),(1,2,1),(2,1,1),(2,2),(1,3),(3,1) -> 7 (3만든거에 1), (2만든거에 2), (1 만든거에 3 == 3,1))
            // 5 -> (4 만든것들에다 +1) / (3 만든거에다 2만든거), (2만든 거에다 3만든거)

            // N 번째 경우의 수 -> x_n = x_n-3 + x_n-2 + x_n-1
            if(N == 1){
                bw.write("1" + "\n");
                continue;
            } else if(N == 2){
                bw.write("2" + "\n");
                continue;
            } else if(N == 3){
                bw.write("4" + "\n");
                continue;
            } else {
                int[] makeN = new int[11];

                makeN[1] = 1;
                makeN[2] = 2;
                makeN[3] = 4;
                for(int i = 4; i <= N; i++){
                    makeN[i] = makeN[i-3] + makeN[i-2] + makeN[i-1];
                }
                bw.write(makeN[N] + "\n");
            }


        }
        bw.flush();
        bw.close();
        br.close();
    }

}
