package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> yosep = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        for(int i = 1; i <= N; i++){
            yosep.add(i);
        }
        int idx = 0;
        int size = N;
        for(int i = 0; i < N; i++){
            idx = (idx+K-1) % size;
            size--;
            if(i < N-1){
                sb.append(yosep.remove(idx)).append(",").append(" ");
            } else if(i == N-1){
                sb.append(yosep.remove(idx)).append(">");

            }

        }

        bw.write(sb + "\n");
        sb.setLength(0);
        bw.flush();
        bw.close();
        br.close();
    }
}
