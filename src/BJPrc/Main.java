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

        int number = 1;
        int index = 0;
        while(number <= N || !numbers.isEmpty() ){

            if(number <= N){
                numbers.push(number);
                number++;
                bw.write("+" + "\n");
            }


            while(!numbers.isEmpty() && numbers.peek() == stackNum[index]){
                numbers.pop();
                bw.write("-" + "\n");
                index++;



            }





        }

        if(index != N){
            bw.write("NO" + "\n");
            return;
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
