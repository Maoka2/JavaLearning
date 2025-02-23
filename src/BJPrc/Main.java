package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while (true) {
            s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean possible = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' ||  s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ')' ||  s.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        possible = false;
                        break;
                    }
                    if (s.charAt(i) == ')' && stack.peek() == '(' ||  s.charAt(i) == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()){
                possible = false;
            }

            if(possible){
                bw.write("yes\n");
            } else{
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

