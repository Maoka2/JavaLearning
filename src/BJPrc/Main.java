package BJPrc;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] numList = new int[N];
        for(int i = 0; i < N; i++){
            numList[i] = Integer.parseInt(s[i]);
        }
        int max = -1;
        int min = 1000001;
        for(int i = 0; i < N; i++){
            if(numList[i] > max){
                max = numList[i];
            }
            if(numList[i] < min){
                min = numList[i];
            }
        }

        bw.write(max * min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
