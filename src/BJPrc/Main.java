package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> l = new ArrayList<>();
    static int a;
    static int b;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        for(int i = 0; i <= N; i++){
            l.add(new ArrayList<>());
        }

        String[] s = br.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            String[] ss = br.readLine().split(" ");
            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt(ss[1]);

            l.get(x).add(y);
            l.get(y).add(x);
        }

        dfs(a,0);

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int node, int depth){
        if(node == b){
            result = depth;
            return;
        }

        visited[node] = true;

        for(int next : l.get(node)){
            if(!visited[next]){
                dfs(next,depth+1);
            }
        }

    }
}