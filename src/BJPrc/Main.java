package BJPrc;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] squares = new int[4][4];

        for(int i = 0; i < 4; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < 4; j++){
                squares[i][j] = Integer.parseInt(s[j]);
            }
        }
        int squareSum = 0;
        for(int i = 0; i < 4; i++){
            squareSum += (Math.abs(squares[i][0] - squares[i][2]) * (Math.abs(squares[i][1]-squares[i][3])));
        }
        // 일단 직사각형들 면적 다 더하고,

        int count = 0;

//        System.out.println(squareSum);


        int[][] countArray = new int[101][101];
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                countArray[i][j] = -1;
            }
        }

        for(int i = 0; i < 4; i++){
            for(int j = squares[i][0]; j < squares[i][2]; j++){
                for(int k = squares[i][1]; k < squares[i][3]; k++){
                    countArray[j][k]++;
                }
            }
        }

        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(countArray[i][j] != -1){
                    squareSum -= countArray[i][j];
                }
            }
        }

        bw.write(squareSum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}