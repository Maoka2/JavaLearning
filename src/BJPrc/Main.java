package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        // 좋은 단어? 뭔소리임

        for(int i = 0; i < N; i++){
            Stack<Character> stack = new Stack<>();

            String s = br.readLine();

            for(int j = 0; j < s.length(); j++){
                if(!stack.isEmpty() && stack.peek() == s.charAt(j)){
                    stack.pop();
                }else{
                    stack.push(s.charAt(j));
                }
            }

            if(stack.isEmpty()){
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}