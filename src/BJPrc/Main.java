package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<String> printing = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        int[] numArray = new int[N + 1];
        String[] numbers = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            numArray[i] = Integer.parseInt(numbers[i - 1]);
        }
        Arrays.sort(numArray);
        boolean[] visitied = new boolean[N + 1];
        int[] result = new int[M];
        backTracking(result, numArray, N, M, 0,visitied);


        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int[] result, int[] arr, int N, int M, int depth, boolean[] visited) throws IOException {
        if (depth == M) {
            String s = "";
            for (int i = 0; i < M; i++) {
                s += result[i] + " ";
            }
            if(!printing.contains(s)){
                printing.add(s);
                bw.write(s + "\n");
            }

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backTracking(result, arr, N, M, depth + 1, visited);
                visited[i] = false;
            }
        }
    }

}



