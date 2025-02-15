package BJPrc;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");


        // 대충 뽑은 번호 수 만큼 앞으로 갈 수 있음
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < N; i++){
            l.add(i-Integer.parseInt(s[i]), i+1);
        }
        for(int num : l){
            bw. write(num + " ");
        }


        bw.flush();
        br.close();
        bw.close();


    }
}