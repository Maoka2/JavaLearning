package BJPrc;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String whole = br.readLine();
        String target = br.readLine();

        Stack<Character> stack = new Stack<>();
        // 넣으면서 확인해보기?

        for(char c : whole.toCharArray()){
            stack.push(c);

            if(stack.size() >= target.length()){
                int count = 0;
                for(int i = 0; i < target.length(); i++){
                    if(stack.get(stack.size() - target.length() + i) == target.charAt(i)){
                        count++;
                    }
                }
                if(count == target.length()){
                    for(int i = 0; i < target.length(); i++){
                        stack.pop();
                    }
                }
            }
        }
        char[] result = new char[stack.size()];
        for(int i = stack.size()-1; i >=0; i--){
            result[i] = stack.pop();
        }

        if(result.length == 0){
            bw.write("FRULA");
        } else{
            bw.write(new String(result));
        }
        bw.flush();
        br.close();
        bw.close();


    }
}
