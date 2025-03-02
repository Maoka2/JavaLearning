package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] balloons = new int[N + 1];
        LinkedList<int[]> ll = new LinkedList<>();
        String[] s = br.readLine().split(" ");

        // 먼저 1번 터뜨리고 종이 값 확인해서 오른쪽으로 숙숙 (양 -> 오 음 -> 왼)
        for (int i = 0; i < N; i++) {
            ll.add(new int[]{i + 1, Integer.parseInt(s[i])});
        }
        int removeIdx = 0;

        while (!ll.isEmpty()) {
            int[] current = ll.remove(removeIdx);
            bw.write(current[0] + " ");

            if (ll.isEmpty()) {
                break;
            }
            int next = current[1];

            if (next > 0) {
                removeIdx = (removeIdx + next - 1) % ll.size();
            } else {
                removeIdx = (removeIdx + next) % ll.size();
                if (removeIdx < 0) {
                    removeIdx += ll.size();
                }
            }

        }


        bw.flush();
        br.close();
        bw.close();
    }
}