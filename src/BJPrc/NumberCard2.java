package BJPrc;

import java.util.*;
import java.io.*;

public class NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 상근이 카드
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Map<Integer,Integer> sk = new HashMap<>();
        int[] intS = new int[n];
        for(int i = 0; i < n; i++){
            intS[i] = Integer.parseInt(s[i]);
        }
        for(int i = 0; i < n; i++){
            if(sk.containsKey(intS[i])){ // 기존 키값 있으면 value 를 +1 씩
                sk.put(intS[i],sk.get(intS[i]) + 1);
            } else if(!(sk.containsKey(intS[i]))){
                sk.put(intS[i],1); // 없으면 새로 추가되는거니까 1
            }
        }
        int m = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        int[] intS2 = new int[m];
        for(int i = 0; i < m; i++){
            intS2[i] = Integer.parseInt(s2[i]);
        }

        for(int i = 0; i < m; i++){
            if(sk.containsKey(intS2[i])){ // 확인하고자 하는 카드 키값 있으면 벨류 출력, 없으면 0
                bw.write(sk.get(intS2[i]) + " ");
            } else{
                bw.write(0 + " ");
            }
        }





        bw.flush();
        bw.close();
        br.close();
    }
}
