package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Map<String, Integer> m = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                m.put(s[1], m.getOrDefault(s[1], 0) + 1);
            }
            int sum = 1;

            for(String str : m.keySet()){
                sum = sum * (m.get(str)+1);
            }

            bw.write(sum-1 + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

