package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            d.add(i + 1);
        }

        String[] s = br.readLine().split(" ");
        int count = 0;

        for (int i = 0; i < s.length; i++) {
            // 왼쪽으로 돌지 오른쪽으로 돌지
            int target = Integer.parseInt(s[i]);
            boolean isClockwise = false;

            if(d.peekFirst() == target){
                d.pollFirst();
                continue;
            }

            int index = 0;
            for(int n : d){
                if(n == target){
                    break;
                }
                index++;
            }

            if (index > d.size() / 2) {
                isClockwise = true;
                // 반띵보다 뒤에 있으면 시계방향으로 도는게 이득 (맨 뒤를 맨 앞으로)
                // 앞이면 반시계 (앞에꺼 맨 뒤로 보내기)
            }
            while(d.peekFirst() != target){
                // 시계방향이면
                if(isClockwise){
                    d.addFirst(d.pollLast());
                    count++;
                } else{
                    d.addLast(d.pollFirst());
                    count++;
                }
            }
            d.pollFirst();
        }
        bw.write(count + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
