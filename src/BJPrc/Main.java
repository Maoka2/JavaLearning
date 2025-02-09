package BJPrc;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stackNum = new int[N];
        for(int i = 0; i < N; i++){
            stackNum[i] = Integer.parseInt(br.readLine()); // 만들고싶은 수열
        }

        Stack<Integer> numbers = new Stack<Integer>();
        StringBuilder sb =new StringBuilder();
        int number = 1;
        int index = 0;
        while(index < N){

            if(number <= stackNum[index]){
                numbers.push(number++);
                sb.append("+\n");

            }else if(!numbers.isEmpty() && numbers.peek() == stackNum[index]){
                numbers.pop();
                sb.append("-\n");
                index++;
            }else{
                bw.write("NO\n");
                bw.flush();
                return;
            }


        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}