package BJPrc;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int head = 0;
        int tail = -1;
        int size = 0;
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            switch (s[0]) {

                case "push_back":
                    deque.offer(Integer.parseInt(s[1]));
                    break;

                case "push_front":
                    deque.push(Integer.parseInt(s[1]));
                    break;

                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    bw.write(deque.pollFirst() + "\n");
                    break;

                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                        break;
                    }
                    bw.write(deque.pollLast() + "\n");
                    break;

                case "size":
                    bw.write(deque.size() + "\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;

                case "front":
                    if (deque.isEmpty()) {
                        bw.write(-1 + "\n");
                        break;
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                        break;
                    }
                case "back":
                    if(deque.isEmpty()){
                        bw.write(-1 + "\n");
                        break;
                    } else{
                        bw.write(deque.peekLast() + "\n");
                        break;
                    }
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }


}

