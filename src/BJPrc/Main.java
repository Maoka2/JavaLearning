package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int V = Integer.parseInt(s[2]);

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] ss = br.readLine().split(" ");
            l.get(Integer.parseInt(ss[0])).add(Integer.parseInt(ss[1]));
            l.get(Integer.parseInt(ss[1])).add(Integer.parseInt(ss[0]));
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(l.get(i));
        }

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> dfs = new ArrayList<>();

        boolean visitedBFS[] = new boolean[N + 1];
        boolean visitedDFS[] = new boolean[N + 1];

        q.add(V);
        stack.push(V);

        visitedDFS[V] = true;
        visitedBFS[V] = true;

        //DFS
        while (!stack.isEmpty()) {
            int node = stack.pop();
            dfs.add(node);
            for (int next : l.get(node)) {
                if (!visitedDFS[next]) {
                    visitedDFS[next] = true;
                    stack.push(next);
                }
            }
        }


        //BFS
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : l.get(node)) {
                if (!visitedBFS[next]) {
                    q.add(next);
                    visitedBFS[next] = true;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

