package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int map[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int total = 0;
        List<Integer> houseNum = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    houseNum.add(bfs(i,j));
                    total++;
                }
            }
        }

        Collections.sort(houseNum);

        bw.write(total + "\n");
        for(int i = 0; i < houseNum.size(); i++){
            bw.write(houseNum.get(i) + "\n");
        }



        bw.flush();
        br.close();
        bw.close();
    }
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int count = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++){
                int mx = cx + dx[i];
                int my = cy + dy[i];

                if(mx >= 0 && my >= 0 && mx < N && my < N){
                    if(map[mx][my] == 1 && !visited[mx][my]){
                        visited[mx][my] = true;
                        count++;
                        q.add(new int[]{mx,my});
                    }
                }
            }
        }
        return count;
    }
}

