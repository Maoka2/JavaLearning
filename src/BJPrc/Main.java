package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        // 여는 괄호면 일단 넣어
        // 여는 괄호가 연속으로 나오면? 곱하기잖음?
        // 2 * 2+ 3*3
        boolean isPossible = true;
        int ans = 0;
        int temp = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                temp *= 2;
            } else if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                temp *= 3;
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    isPossible = false;
                    break;
                }
                if (s.charAt(i-1) == '(') {
                    ans += temp;
                }
                stack.pop();
                temp /= 2;

            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    isPossible = false;
                    break;
                }
                if (s.charAt(i-1) == '[') {
                    ans += temp;
                }
                temp /= 3;
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            isPossible = false;
        }

        if(!isPossible){
            bw.write(0 + "\n");
        }else{
            bw.write(ans + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

