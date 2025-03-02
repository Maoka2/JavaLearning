package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        double result = 0;
        double[] numbers = new double[N];

        for(int i = 0; i < N; i++){
            numbers[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                stack.push(numbers[s.charAt(i)-'A']);
            }else{ // 연산자
                double a = stack.pop();
                double b = stack.pop();

                switch(s.charAt(i)){
                    case '+':
                        stack.push(b+a);
                        break;

                    case '-':
                        stack.push(b-a);
                        break;

                    case '*':
                        stack.push(b*a);
                        break;

                    case '/':
                        stack.push(b/a);
                        break;
                }
            }
        }
        bw.write(String.format("%.2f",stack.pop()) + "\n");

        bw.flush();
        br.close();
        bw.close();

    }
}