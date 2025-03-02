package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ㅇ목한게 없다 -> 오름차순 -> 내림차순

        int N = Integer.parseInt(br.readLine());
        int init = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int max = -1;
        int maxIdx = 0;

        int[] arr = new int[1001];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int L = Integer.parseInt(s[0]);
            int H = Integer.parseInt(s[1]);

            arr[L] = H;
            init = Math.min(init, L);
            end = Math.max(end, L);
            max = Math.max(max,H);
            if(max == H){
                maxIdx = L;
            }
        }

        int height = arr[init];
        int s = 0;

        for (int i = init + 1; i <= maxIdx; i++) {
            if (arr[i] >= height) {
                s += (i - init) * height;
                height = arr[i];
                init = i;
            }
        }

        height = arr[end];

        for (int i = end - 1; i >= maxIdx; i--) {
            if (arr[i] >= height) {
                s += height * (end - i);
                height = arr[i];
                end = i;
            }
        }

        s += max;
        bw.write(s + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}