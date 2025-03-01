package BJPrc;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nmv = br.readLine().split(" ");
        int N = Integer.parseInt(nmv[0]);
        int M = Integer.parseInt(nmv[1]);
        int V = Integer.parseInt(nmv[2]);

        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            l.get(a).add(b);
            l.get(b).add(a);

        }
        for(int i = 0; i <= N; i++){
            Collections.sort(l.get(i));
        }

        //DFS
        boolean[] visited1 = new boolean[N+1];
        dfs(V,l,visited1);
        bw.write("\n");
        //BFS
        boolean[] visited2 = new boolean[N+1];
        bfs(V,l,visited2);
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int node, List<List<Integer>> list, boolean[] visited) throws IOException{
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            int current = stack.pop();

            if(!visited[current]){
                visited[current] = true;
                bw.write(current + " ");

                List<Integer> adjacent = list.get(current);

                for(int i = adjacent.size()-1; i >=0; i--){
                    if(!visited[adjacent.get(i)]){
                        stack.push(adjacent.get(i));
                    }
                }
            }
        }
    }

    static void bfs(int node, List<List<Integer>> list, boolean[] visited) throws IOException{
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int current = q.poll();
            bw.write(current + " ");

            for(int next : list.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}