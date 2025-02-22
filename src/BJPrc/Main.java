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
        int result = 1;
        int divide = 1;
        int count = K;
        for(int i = 0; i < count; i++){
            result *= N;
            divide *= K;
            N--;
            K--;
        }

        bw.write(result/divide + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
