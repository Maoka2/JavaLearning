package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 6667 이런것도 종말의 수?
        int count = 0;
        int num = 0;
        while(count != N){
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        bw.write(num + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
