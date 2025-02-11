package BJPrc;
import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            Stack<Integer> numStack = new Stack<>();
            for(int i = 0; i < N; i++){
                int n = Integer.parseInt(br.readLine());
                if(n != 0){
                    numStack.push(n);
                } else{
                    if(!numStack.isEmpty()){ // 보장한다고하긴함
                        numStack.pop();
                    }
                }
            }
            int sum = 0;
            for(int num : numStack){
                sum += num;
            }

        bw.write(sum + "\n");

        bw.flush();
        br.close();
        bw.close();


    }
}