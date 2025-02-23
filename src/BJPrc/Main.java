package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("add")) {
                set.add(Integer.parseInt(s[1]));
            } else if (s[0].equals("check")) {
                if (set.contains(Integer.parseInt(s[1]))) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (s[0].equals("remove")) {
                set.remove(Integer.parseInt(s[1]));
            } else if (s[0].equals("toggle")) {
                if (set.contains(Integer.parseInt(s[1]))) {
                    set.remove(Integer.parseInt(s[1]));
                } else {
                    set.add(Integer.parseInt(s[1]));
                }
            } else if (s[0].equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (s[0].equals("empty")) {
                set.clear();
            }


        }

        bw.flush();
        bw.close();
        br.close();
    }
}
