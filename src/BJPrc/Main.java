package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] members = new String[N][2];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            members[i][0] = s[0];
            members[i][1] = s[1];
        }

        Arrays.sort(members, new Comparator<String[]>(){

            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(members[i][0] + " " + members[i][1] + "\n");


        }


        bw.flush();
        bw.close();
        br.close();
    }
}
