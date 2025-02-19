package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int max = -1;
        int maxIdx = -1;
        Stack<Integer> towers = new Stack<>();
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(s[i]);
        }
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            while (!towers.isEmpty() && temp[i] > temp[towers.peek()]) {
                towers.pop();
            }

            if (towers.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = towers.peek() + 1;
            }

            towers.push(i);
        }

        boolean isZeros = true;

        for (int n : result) {
            if (n != 0) {
                isZeros = false;
            }
        }

        if (isZeros) {
            sb.append(0);
        } else {
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append(" ");
            }
        }

        String ans = sb.toString().trim();

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

