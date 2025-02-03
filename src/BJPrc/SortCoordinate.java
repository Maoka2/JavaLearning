package BJPrc;


import java.util.*;
import java.io.*;

public class SortCoordinate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] xy_coor = new int[n][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim(); // 한줄로 입력 받기
            String[] input = s.split(" ");

            xy_coor[i][0] = Integer.parseInt(input[0]);
            xy_coor[i][1] = Integer.parseInt(input[1]);
        } // x, y 좌표 각각 입력받았음

        // x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬 이거 해야됨
        // 그냥 x좌표 정렬해버리고 나머지는 y좌표로?
        // x가 더 작으면 먼저 오기
        // x가 같으면 y작은게 먼저 오기
        Arrays.sort(xy_coor, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]); // x가 같으면 y 오름차순
                }
                return Integer.compare(a[0], b[0]); // x 기준 오름차순
            }
        });

        for(int i = 0; i < n; i++){
            bw.write(xy_coor[i][0] + " " + xy_coor[i][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
