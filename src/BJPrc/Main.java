package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int fiveCount = 0;
        int count = 0;

        for(int i = 1; i <= N; i++){
            int num = i;

            while(num >= 5){
                if(num % 5 == 0){
                    fiveCount++;
                    num /= 5;
                } else{
                    break;
                }
            }
        }

        bw.write(fiveCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
