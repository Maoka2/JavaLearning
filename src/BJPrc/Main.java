package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]); // 1~N
        int M = Integer.parseInt(nm[1]); // 길이가 M
        // 수열의 길이가 M이 된다면 끝내기
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }

        boolean visited[] = new boolean[N+1];
        backTracking(arr,visited,N,M,0);




        bw.flush();
        bw.close();
        br.close();
    }
    public static void backTracking(int[] sequence, boolean[] visited, int N, int M , int depth) throws IOException {
        if(depth == M){
            for(int i = 0; i < M; i++){
                bw.write(sequence[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                sequence[depth] = i;
                visited[i] = true;
                backTracking(sequence,visited,N,M,depth+1);
                visited[i] = false;
            }
        }
    }
}
