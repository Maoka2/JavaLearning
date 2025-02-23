package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            Deque<int[]> q = new ArrayDeque<>();
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            String[] pri = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                q.add(new int[]{Integer.parseInt(pri[j]), j});
            }

            int count = 0;

            while(!q.isEmpty()){
                int[] current = q.pollFirst();
                int priority = current[0];
                int idx = current[1];
                boolean isHigher = false;
                // 우선순위가 더 높은게 있다면 current 맨 뒤로 보내기
                for(int[] n : q){
                    if(n[0] > priority){
                        isHigher = true;
                        break;
                    }
                }

                if(isHigher){
                    q.addLast(current);
                } else{
                    count++;
                    if(idx == M){
                        bw.write(count + "\n");
                        break;
                    }
                }
            }


        }
        bw.flush();
        bw.close();
        br.close();
    }
}
