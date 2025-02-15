package BJPrc;
import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 남학생은 남학생끼리, 여는 여끼리
        // 같은 학년끼리 , 혼자쓰는것도 가능
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]); // 학생인원
        int K = Integer.parseInt(NK[1]); // 방 최대인원수
        // 여 0 , 남 1
        // 0번인덱스 : 학년, 1번인덱스 : 성별

        int[][] student = new int[6][2];  // 남자면 1번 인덱스에 넣을거고 여자면 0 번 인덱스에 넣을거임

        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");
            int MFM = 0;
            int grade = 0;
            if(Integer.parseInt(s[0]) == 1){
                MFM = 1;
            } else if(Integer.parseInt(s[0]) == 0){
                MFM = 0;
            }
            grade = Integer.parseInt(s[1])-1;

            student[grade][MFM]++;
        }

        int count = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 2; j++){
                if(student[i][j] <= K && student[i][j] > 0){
                    count++;
                } else if (student[i][j] > K){
                    if(student[i][j] % K == 0){
                        count += student[i][j] / K;
                    } else{
                        count += student[i][j] / K + 1;
                    }
                }
            }
        }

        bw. write(count + "\n");
        bw.flush();
        br.close();
        bw.close();


    }
}