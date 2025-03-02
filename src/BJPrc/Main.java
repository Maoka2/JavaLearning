package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); //여는거 제거
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sb.append(s.charAt(i));
            } else {
                while (!stack.isEmpty() && ((stack.peek() == '*' || stack.peek() == '/') ||
                        (s.charAt(i) == '+' || s.charAt(i) == '-') && (stack.peek() == '+' || stack.peek() == '-'))) {
                    sb.append(stack.pop());


                }
                stack.push(s.charAt(i));
            }




        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}