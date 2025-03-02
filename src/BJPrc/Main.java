package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] np = br.readLine().split(" ");
        int N = Integer.parseInt(np[0]);
        int P = Integer.parseInt(np[1]);

        // 현재 프렛? 보다 크면 그냥 누르고있고 작아지면 떼버리기?
        ArrayList<Stack<Integer>> l = new ArrayList<>();

        int count = 0;

        for(int i = 0; i < 6; i++){
            l.add(new Stack<>());
        }

        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");
            int line = Integer.parseInt(s[0]);
            int vmfpt = Integer.parseInt(s[1]);


            while(!l.get(line-1).isEmpty() && l.get(line-1).peek() > vmfpt){
                l.get(line-1).pop();
                count++;
            }

            if(l.get(line-1).isEmpty() || l.get(line-1).peek() != vmfpt){
                l.get(line-1).push(vmfpt);
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}