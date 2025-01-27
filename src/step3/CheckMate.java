package step3;

import java.util.*;
public class CheckMate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int tc = 1; tc<=t; tc++){
            int n = sc.nextInt();
            int[] kqxy = new int[4];
            for(int i = 0; i<kqxy.length; i++){
                kqxy[i] = sc.nextInt();
            }

            int kx = kqxy[0];
            int ky = kqxy[1];
            int qx = kqxy[2];
            int qy = kqxy[3];  // 킹 가로세로, 퀸 가로세로

            // 가로나 세로 같으면 일단 잡히는거고

            if(kx == qx || ky == qy || Math.abs(kx-qx) == Math.abs(ky-qy)){
                System.out.println("#" + tc + " 1\n");
            } else{
                System.out.println("#" + tc + " 0\n");
            }

        }
    }
}