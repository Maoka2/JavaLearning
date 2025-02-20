package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        // 일단 넣어
        // W의 합이 K보다 크면 안되고
        // V는 최대가 되었으면...

        int[] arr = new int[K + 1]; // 무게 1~K 까지일 때의 value?

        int[][] products = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] ss = br.readLine().split(" ");
            int W = Integer.parseInt(ss[0]);
            int V = Integer.parseInt(ss[1]);
            products[i][0] = W;
            products[i][1] = V;

            for (int j = K; j >= W; j--){
                arr[j] = Math.max(arr[j], arr[j-W] + V);
            }
        }

        bw.write(arr[K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
