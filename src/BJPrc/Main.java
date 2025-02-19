package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 최소가 되려면? -> - 부호 뒤에서부터 + 숫자 나올때까지 묶여야
        // 수식 내 모든 연산자가 같다면? 굳이...
        // - 처음 나타나는 인덱스를 찾고, 제일 늦게 + 나타나는 인덱스를 찾는다? // -가 하나라면
        // 근데 - + - + 이런식으로 번갈아가면서 나오면? 다음 - 전까지 묶으면 됨

        String[] s = br.readLine().split("-");

        int result = 0;

        String[] beforeMinus = s[0].split("\\+");

        for (String str : beforeMinus) {
            result += Integer.parseInt(str);
        }

        for (int i = 1; i < s.length; i++) {
            String[] str = s[i].split("\\+");
            int sum = 0;
            for (String ss : str) {
                sum += Integer.parseInt(ss);
            }

            result -= sum;
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

