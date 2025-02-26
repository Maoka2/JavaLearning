package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        boolean isLast = true;

        Deque<Character> d = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            d.add(s.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] ss = br.readLine().split(" ");
            if (ss[0].charAt(0) == 'P') {
                d.addLast(ss[1].charAt(0));
            } else if (ss[0].charAt(0) == 'L') {
                if (!d.isEmpty()) {
                    temp.addFirst(d.pollLast());
                }
            } else if (ss[0].charAt(0) == 'D') {
                if (!temp.isEmpty()) {
                    d.addLast(temp.pollFirst());
                }
            } else { //B
                if(!d.isEmpty()){
                    d.pollLast();
                }
            }
        }

        while(!d.isEmpty()){
            bw.write(d.pollFirst());
        }

        while(!temp.isEmpty()){
            bw.write(temp.pollFirst());
        }

        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

