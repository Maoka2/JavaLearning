package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R;
    static boolean[] visited;
    static int[] order;
    static int count = 0;
    static ArrayList<ArrayList<Integer>> l = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmr = br.readLine().split(" ");
        N = Integer.parseInt(nmr[0]);
        M = Integer.parseInt(nmr[1]);
        R = Integer.parseInt(nmr[2]);
        order = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            l.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            l.get(u).add(v);
            l.get(v).add(u);
        }

        for(int i = 1; i <= N; i++){
            l.get(i).sort(Collections.reverseOrder());
        }


        dfs(R);

        for(int i = 1; i <= N; i++){
            bw.write(order[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int R){
        visited[R] = true;
        order[R] = ++count;

        for(int next : l.get(R)){
            if(!visited[next]){
                dfs(next);
            }
        }

    }
}

