package BJPrc;

import java.util.*;
import java.io.*;

public class VPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            Stack<Character> st = new Stack<>();
            String str = br.readLine();
            boolean yesOrNo = true;
            for (char c : str.toCharArray()) {
                if (c == ('(')) {
                    st.push(c);
                } else if (c == (')')) {
                    if (st.isEmpty()) {
                        yesOrNo = false;
                        break;
                    }
                    st.pop();
                }
            }
            if(!(st.isEmpty())){
                yesOrNo = false;
            }
            if(yesOrNo){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }


}


