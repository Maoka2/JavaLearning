package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        Deque<Integer> cards = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            cards.add(i);
        }
        int initSize = cards.size();
        while(initSize > 1){
            cards.pollFirst();
            cards.add(cards.pollFirst());
            initSize--;
        }
        bw.write(cards.peekFirst() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
