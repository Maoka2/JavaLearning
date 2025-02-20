package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] size = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            size[i] = Integer.parseInt(s[i]);
        }
        String[] ss = br.readLine().split(" ");
        int T = Integer.parseInt(ss[0]);
        int P = Integer.parseInt(ss[1]);
        // T -> 각 나누기 5 몫 + 1
        //펜 -> N / P, N % P

        int tCount = 0;
        for (int i = 0; i < s.length; i++) {
            if (size[i] % T != 0) {
                tCount += (size[i] / T) + 1;
            } else{
                tCount += size[i] / T;
            }
        }
        bw.write(tCount + "\n");
        bw.write(N / P + " " + N % P + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
