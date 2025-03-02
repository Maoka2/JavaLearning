package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 친구 -> 자신과 반 등수 차이가 K를 넘으면 친구가 아니라는거
        // 좋은 친구 -> 이름의 길이가 같아야, 등수 차이가 K이하이면서

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        long count = 0;

        int[] nameLength = new int[N];

        for(int i = 0; i < N; i++){
            nameLength[i] = br.readLine().length();
        }
        int[] lengths = new int[21];

        Deque<Integer> d = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            int length = nameLength[i];
            count += lengths[length];

            d.addLast(length);
            lengths[length]++;

            if(d.size() > K){
                int remove = d.pollFirst();
                lengths[remove]--;
            }
        }




        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}