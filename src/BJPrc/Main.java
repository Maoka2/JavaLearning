package BJPrc;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 라운드 수

        for (int tc = 0; tc < N; tc++) {
            Map<Integer, Integer> aMap = new HashMap<>();
            Map<Integer, Integer> bMap = new HashMap<>();

            String[] sa = br.readLine().split(" ");
            int[] ia = new int[sa.length - 1];
            for (int i = 1; i < sa.length; i++) {
                ia[i - 1] = Integer.parseInt(sa[i]);
            }

            boolean draw = true;

            for (int i = 0; i < ia.length; i++) {
                aMap.put(ia[i], aMap.getOrDefault(ia[i], 0) + 1);
            }

            String[] sb = br.readLine().split(" ");
            int[] ib = new int[sb.length - 1];
            for (int i = 1; i < sb.length; i++) {
                ib[i - 1] = Integer.parseInt(sb[i]);
            }

            for (int i = 0; i < ib.length; i++) {
                bMap.put(ib[i], bMap.getOrDefault(ib[i], 0) + 1);
            }

            for (int i = 4; i >= 1; i--) {
                if (aMap.getOrDefault(i, 0) > bMap.getOrDefault(i, 0)) {
                    bw.write("A\n");
                    draw = false;
                    break;
                } else if (bMap.getOrDefault(i, 0) > aMap.getOrDefault(i, 0)) {
                    bw.write("B\n");
                    draw = false;
                    break;
                }
            }
            if (draw) {
                bw.write("D\n");
            }

            // 규칙 : 우선순위 : 별 > 동그라미 > 네모 > 세모
            // 숫자 다 같으면 무승부
            // 별 : 4 동그라미 : 3 네모 : 2 세모 : 1


        }


        bw.flush();
        br.close();
        bw.close();


    }
}