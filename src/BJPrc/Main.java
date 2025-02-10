package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> treeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            treeList.add(Integer.parseInt(br.readLine()));
        }

        int[] interval = new int[N-1];
        for (int i = 0; i < N - 1; i++) {
            interval[i] = treeList.get(i+1) - treeList.get(i);
        }

        int gcd = findMulti(interval);
        // 각 나무 간격 얼마나 할 지 정했음

        int count = (treeList.get(treeList.size()-1) - treeList.get(0))/gcd +1;




        bw.write((count - treeList.size()) + "\n");


        bw.flush();
        bw.close();
        br.close();
    }

    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a%b);
    }

    public static int findMulti(int[] arr){
        int gcd = arr[0];
        for(int i = 1; i < arr.length; i++){
            gcd = GCD(gcd,arr[i]);
        }
        return gcd;
    }
}
