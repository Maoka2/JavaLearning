package step3;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt(); // 배열 크기
            String[][] area = new String[n][n]; // G/B 넣는거
            int[][] buildNum = new int[n][n]; // 빌딩높이


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    area[i][j] = sc.next();
                }
            }

            int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; // 상하좌우 1시 3시 5시 7시
            int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1}; // 동일


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (area[i][j].equals("G")) {
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && area[nx][ny].equals("B")) {
                                buildNum[nx][ny] = 2;
                            }
                        }
                    }
                }
            }
            //요까지 해서 G 인접구역 빌딩높이 2로 초기화

            // G인접 안한경우
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (area[i][j].equals("B") && buildNum[i][j] == 0) { // 주변에 G 없으면 아직 층수 모르니까
                        int bCount = 0;


                        for (int col = 0; col < n; col++) {
                            if (area[i][col].equals("B")) {
                                bCount++;
                            }
                        }


                        for (int row = 0; row < n; row++) {
                            if (area[row][j].equals("B")) {
                                bCount++;
                            }
                        }


                        buildNum[i][j] = bCount - 1; // 중복 제거
                    }
                }
            }


            // 결과 출력
            int max = -1;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    max = Math.max(max, buildNum[i][j]);
                }
            }
            System.out.println("#" + tc + " " + max);

        }
    }
}


