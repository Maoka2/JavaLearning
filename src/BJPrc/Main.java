package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String s = br.readLine();
            if(s.equals("0")){
                break;
            } // 0들어오면 끝내기

            char[] temp = s.toCharArray();
            char[] reversed = new char[temp.length];
            for(int i = 0; i < s.length(); i++){
                reversed[i] = temp[s.length()-i-1];
            }
            String s2 = new String(reversed);
            if(s.equals(s2)){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }





        bw.flush();
        bw.close();
        br.close();
    }
}
