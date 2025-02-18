package BJPrc;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String strX = br.readLine();
            if (n > 0) {
                String[] strArrayX = strX.substring(1, strX.length() - 1).split(",");
                for (int i = 0; i < strArrayX.length; i++) {
                    deque.add(Integer.parseInt(strArrayX[i]));
                }
            }
            boolean isError = false;
            boolean isReversed = false;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isReversed = !isReversed;
                    // 뒤집어져있지 않으면? 그냥 앞에서 빼버리고
                    // 아니면? 뒤에서 빼버리기
                    // 메모리 관점? 새로운 덱 만드는게 좋아보이진 않아서 이제

                } else if (p.charAt(i) == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        bw.write("error\n");
                        break;
                    }
                    // reverse T/F 에 따라서 이제 bw pollFirst / pollLast 할건지 그것만 해주면 될것같다.
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }
            // 에러면 굳이 뭐 건드릴필요없고, 에러가 아닌경우에만 출력을 해주면 되겠다.
            if (!isError) {
                bw.write("[");

                int fSize = deque.size();
                for (int i = 0; i < fSize; i++) {
                    if (isReversed) {
                        bw.write(String.valueOf(deque.pollLast()));
                    } else {
                        bw.write(String.valueOf(deque.pollFirst()));
                    }
                    if(i < fSize -1){
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

