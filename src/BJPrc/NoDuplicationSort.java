package BJPrc;

import java.util.*;
import java.io.*;

public class NoDuplicationSort{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] intArray = new int[n];
        String[] ss = br.readLine().split(" ");
        Set<Integer> s1 = new HashSet<>();

        for(int i = 0; i < n; i++){
           s1.add(Integer.parseInt(ss[i]));
        }
        List<Integer> l1 = new ArrayList<>(s1);
        l1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }); // Collections.sort(l1) 이 더 좋을듯
        for(int i = 0; i < l1.size(); i++){
            bw.write(l1.get(i) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
