package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int computer = Integer.parseInt(br.readLine());
        int lines = Integer.parseInt(br.readLine());
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= computer; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < lines; i++) {
            String[] s = br.readLine().split(" ");
            l.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            l.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[computer + 1];
        int count = 0;
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : l.get(node)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

