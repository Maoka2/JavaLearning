package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int count = 0;
            String s = br.readLine();
            String aeiou = "aeiouAEIOU";
            if(s.equals("#")){
                break;
            } // #들어오면 끝내기
            for(int i = 0; i <s.length(); i++){
                if(aeiou.indexOf(s.charAt(i)) != -1){
                    count++;
                }
            }
            bw.write(count + "\n");
        }





        bw.flush();
        bw.close();
        br.close();
    }
}
