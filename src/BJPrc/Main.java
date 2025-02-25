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
        Set<String> set = new HashSet<>();
        // 듣도 못한
        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }

        String name;
        int count = 0;
        List<String> l = new ArrayList<>();
        while((name = br.readLine()) != null){
            if(set.contains(name)){
                count++;
                l.add(name);
            }
        }
        bw.write(count + "\n");
        Collections.sort(l);
        for(String ss : l){
            bw.write(ss + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
