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

        Map<Integer, String> dogam = new HashMap<>();
        Map<String, Integer> dogam2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            dogam.put(i, name);
            dogam2.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String ss = br.readLine();

            if (Character.isDigit(ss.charAt(0))) {
                bw.write(dogam.get(Integer.parseInt(ss)) + "\n");
            } else {
                bw.write(dogam2.get(ss) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

