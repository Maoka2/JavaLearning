package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 주어지는 수들
        int k = Integer.parseInt(s[1]);

        List<Integer> yosep = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            yosep.add(i);
        }
        sb.append("<");
        int index = 0;
        while(!yosep.isEmpty()){
            index = (index + k -1) % yosep.size();
            sb.append(yosep.remove(index));
            if(!yosep.isEmpty()){
                sb.append(", ");
            }



        }
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
