package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<ArrayList<Integer>> l = new ArrayList<>();
    static boolean[] visited;
    static int[] nodes;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmr = br.readLine().split(" ");
        N = Integer.parseInt(nmr[0]);
        M = Integer.parseInt(nmr[1]);
        R = Integer.parseInt(nmr[2]);

        for(int i = 0; i <= N; i++){
            l.add(new ArrayList<>());
        }
        nodes = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);

            l.get(u).add(v);
            l.get(v).add(u);

        }

        for(int i = 1; i <= N; i++){
            Collections.sort(l.get(i));
        }

        dfs(R);

        for(int i = 1; i < nodes.length; i++){
            bw.write(nodes[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    static void dfs(int node){
        visited[node] = true;
        nodes[node] = ++count;

        for(int next : l.get(node)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}

