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
        boolean[] visited = new boolean[N+1];

        backTracking(num,visited,N,M,0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int[] arr, boolean[] visited, int N, int M, int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++){ // 오름차순이니까 이미 되있는거보다는 지금 탐색?하는게 크게끔
           // if((depth == 0 || i >= arr[depth-1])){
                //visited[i] = true;
                arr[depth] = i;
                backTracking(arr, visited, N, M, depth+1);
                //visited[i] = false;

            }
        }
    }



