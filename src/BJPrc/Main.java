package BJPrc;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        Arrays.sort(heights);
        for(int i = 0; i < 9; i++){
            sum += heights[i];
        }

        // 다 더해서 일단 다 빼면서  100일 때 break;
        int minus1 = 0;
        int minus2 = 0;
        a:
        for(int i = 0; i <= 7; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - heights[i] - heights[j] == 100){
                    minus1 = heights[i];
                    minus2 = heights[j];
                    break a;
                }
            }
        }

        for(int i = 0; i  < 9; i++){
            if(heights[i] != minus1 && heights[i] != minus2){
                bw.write(heights[i] + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();


    }
}