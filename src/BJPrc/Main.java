package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> l = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");

        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

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

        visited = new boolean[N+1];

        int count = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }


        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : l.get(node)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}

