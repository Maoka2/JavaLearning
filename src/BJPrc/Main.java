package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[] num = new int[M];
        //boolean[] visited = new boolean[N + 1];

        backTracking(num,N,M,0);


        bw.flush();
        bw.close();
        br.close();
    }
    static void backTracking(int[] arr, int N, int M, int depth) throws IOException{
        if(depth == M){
            for(int i = 0; i < M; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(depth == 0 || arr[depth -1] <= i){
                arr[depth] = i;
                backTracking(arr,N,M,depth + 1);
            }
        }
    }

}



