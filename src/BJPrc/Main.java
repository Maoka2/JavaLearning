package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Map<String,String> m = new HashMap<>();

        for(int i = 0; i < N; i++){
            String[] pw = br.readLine().split(" ");
            m.put(pw[0],pw[1]);
        }

        for(int i = 0; i < M; i++){
            String ss = br.readLine();
            bw.write(m.get(ss) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

