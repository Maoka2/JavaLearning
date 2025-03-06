package BJPrc;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] esm = br.readLine().split(" ");

        int E = Integer.parseInt(esm[0]);
        int S = Integer.parseInt(esm[1]);
        int M = Integer.parseInt(esm[2]);

        int year = 1;
        int earth = 1;
        int sun = 1;
        int moon = 1;

        while(!(earth == E && sun == S && moon == M)){
            year++;
            earth++;
            sun++;
            moon++;

            if(earth > 15){
                earth = 1;
            }

            if(sun > 28){
                sun = 1;
            }

            if(moon > 19){
                moon = 1;
            }


        }

        bw.write(year + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}