package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int[] twoNumbers = new int[2];
        twoNumbers[0] = Integer.parseInt(s[0]);
        twoNumbers[1] = Integer.parseInt(s[1]);



        if (twoNumbers[1] < 2) {
            bw.flush();
            bw.close();
            br.close();
            return; // 소수가 없는 경우
        }
        if (twoNumbers[0] <= 2 && twoNumbers[1] >=2) {
            bw.write(2 + "\n"); // 이러면 일단 2는 확실히 있으니까
            twoNumbers[0] = 3;
        } else if(twoNumbers[0] % 2 == 0){
            twoNumbers[0]++;
        }


        for (int i = twoNumbers[0]; i <= twoNumbers[1]; i= i+2) {
            boolean isPrime = true;


            for (int j = 3; j * j <= i; j = j + 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                bw.write(i + "\n");
            }
        }

        // 어차피 짝수는 무조건 아니고 ( 2 제외) , 그러면 twoNumbers[0] 이 2 이상이면 일단 bw.write 2 해주기?
        // i=3 , for loop 돌 때마다 i = i+2, 제곱수 까지만 보면 됨
        bw.flush();
        bw.close();
        br.close();
    }
}
