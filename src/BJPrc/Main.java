package BJPrc;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        // 최소 공배수 , 최대 공약수?
        // 최소 공배수 -> 최대공약수 * 각 수 최대공약수로 나눈 몫
        // 최대 공약수는? 작은 수의 약수로 큰 수를 나누었을 때 나머지가 0 이 되는 놈들 중 가장 큰 거?
        if(a == b){

            bw.write(a + "\n");
            bw.write(a + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int max = Math.max(a,b);
        int min = Math.min(a,b);

        while(min != 0){
            int d = max % min;
            max = min;
            min = d;
        }




        int minMultiply = a*b/max;
        bw.write(max + "\n");
        bw.write(minMultiply + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}

