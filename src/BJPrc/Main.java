package BJPrc;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String[] hw = br.readLine().split(" ");
        int H = Integer.parseInt(hw[0]);
        int W = Integer.parseInt(hw[1]);

        char[][] cloud = new char[H][W];

        for(int i = 0; i < H; i++) {
            String s = br.readLine();
            for(int j = 0; j < W; j++) {
                cloud[i][j] = s.charAt(j);
            }
        }
        int[][] result = new int[H][W];
        for(int i = 0; i < H; i++) {
            int temp = -1;
            for(int j = 0; j < W; j++) {
                if(cloud[i][j] == 'c'){
                    temp = 0;
                } else if(temp != -1){
                    temp++;
                }
                result[i][j] = temp;
            }
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }












        bw.flush();
        bw.close();
        br.close();
    }
}
