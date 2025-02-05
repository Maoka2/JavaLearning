package BJPrc;

import java.io.*;
import java.util.*;

public class SortWord {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(br.readLine().trim());
        } // 입력
        List<String> list = new ArrayList<>(set);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return Integer.compare(o1.length(),o2.length());
                }
                    return o1.compareTo(o2);
                }
                });
                    for(String s : list){
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
