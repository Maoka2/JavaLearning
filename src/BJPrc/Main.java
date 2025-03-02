package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]); // 바퀴칸
        int K = Integer.parseInt(nk[1]); // 몇번돌릴지

        char[] fnffpt = new char[N];
        for(int i = 0; i < N; i++){
            fnffpt[i] = '?';
        }

        boolean[] alphabet = new boolean[26];
        int current = 0;
        for(int i = 0; i < K; i++){
            String[] s = br.readLine().split(" ");
            int next = Integer.parseInt(s[0]);
            current = current - next % N;
            if(current < 0){
                current += N;
            }

            if(fnffpt[current] != '?' && fnffpt[current] != s[1].charAt(0)){
                bw.write("!\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            } // 이미 뭔가 있는경우

            // 이미 쓴거라면
            if(fnffpt[current] == '?' && alphabet[s[1].charAt(0) - 'A']){
                bw.write("!\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
            fnffpt[current] = s[1].charAt(0);
            alphabet[s[1].charAt(0) - 'A'] = true;

        }



        for(int i = 0; i < N; i++){
            bw.write(fnffpt[(current + i) % N]);
        }
        bw.write("\n");





        bw.flush();
        br.close();
        bw.close();
    }
}