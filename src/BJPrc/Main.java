package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 백스페이스 -


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            LinkedList<Character> ll = new LinkedList<>();
            LinkedList<Character> ans = new LinkedList<>();

            for (char c : s.toCharArray()) {
                ll.add(c);
            }
            int idx = 0;
            while (!ll.isEmpty()) {
                char current = ll.pollFirst();
                if (current == '<') {
                    if (idx > 0) {
                        idx--;
                    }
                } else if (current == '>') {
                    if (idx < ans.size()) {
                        idx++;
                    }
                } else if (current == '-') {
                    if (idx > 0) {
                        ans.remove(idx - 1);
                        idx--;
                    }
                } else {
                    ans.add(idx, current);
                    idx++;
                }
            }
            for(char c : ans){
                bw.write(c);
            }
            bw.write("\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}