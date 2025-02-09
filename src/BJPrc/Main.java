package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] lope = new int[N];
        for(int i = 0; i < N; i++){
            lope[i] = Integer.parseInt(br.readLine());
        }
        // 로프가... 음
        // ex) 10 15 -> 처음에 10, 그 다음엔? 10 15 면 10 *2
        // ex) 10 10 15 15 20 20 -> (10 -> 10), (10,10 -> 10 10 -> 20) , (10,10,15 -> 10,10,10 -> 30)
        // (10,10,15,15 -> 10 * 4)
        // 들 수 있는 최대 무게 -> 지금 연결된 로프들 중 얘가 들 수 있는 최소 무게로프 * 현재 연결 된 로프 개수?
        // 모든 로프 사용할 필요는 없음니다.?
        //
        int max = -1;
        int count = 1;
        Arrays.sort(lope); // 로프를 오름차순으로 정렬을 해본다. 내림차순이 더 좋을 것 같다.

        for(int i = N-1; i >=0; i--){

            int weight = lope[i] * (N-i);
            max = Math.max(max,weight);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
