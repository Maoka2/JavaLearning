package BJPrc;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int[] n = new int[s.length];
        for(int i = 0; i < n.length; i++){
            n[i] = Integer.parseInt(s[i]);
        }
        int max = 0;
        int min = 0;
        // 최소 공배수 , 최대 공약수?
        // 최소 공배수 -> 최대공약수 * 각 수 최대공약수로 나눈 몫
        // 최대 공약수는? 작은 수의 약수로 큰 수를 나누었을 때 나머지가 0 이 되는 놈들 중 가장 큰 거?
        if(n[0] > n[1]){
            max = n[0];
            min = n[1];
        } else if(n[0] < n[1]){
            max = n[1];
            min = n[0];
        } else{
            bw.write(n[0] + "\n");
            bw.write(n[0] + "\n");
        }

        int a = max;
        int b = min;
        int remains = 1;
        int temp = 1;
        while(true){
            remains = b;
            temp = a % b;
            b = temp;

            if(temp == 0){
                bw.write(remains + "\n");
                break;
            }
        }


        int minMultiply = remains * (max / remains) * (min / remains);
        bw.write(minMultiply + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}

