package BJPrc;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] fb = new String[3];
        int max = -1;
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            fb[i] = br.readLine();
            if (!fb[i].equals("Fizz") && !fb[i].equals("Buzz") && !fb[i].equals("FizzBuzz")) {
                if (Integer.parseInt(fb[i]) > max) {
                    max = Integer.parseInt(fb[i]);
                    idx = i;
                }
            }
        }

        switch (idx) {

            case 0:
                max += 3;
                if (max % 15 == 0) {
                    bw.write("FizzBuzz\n");
                } else if (max % 5 == 0) {
                    bw.write("Buzz");
                } else if (max % 3 == 0) {
                    bw.write("Fizz");
                } else {
                    bw.write(max + "\n");
                }
                break;

            case 1:
                max += 2;
                if (max % 15 == 0) {
                    bw.write("FizzBuzz\n");
                } else if (max % 5 == 0) {
                    bw.write("Buzz");
                } else if (max % 3 == 0) {
                    bw.write("Fizz");
                } else {
                    bw.write(max + "\n");
                }
                break;

            case 2:
                max += 1;
                if (max % 15 == 0) {
                    bw.write("FizzBuzz\n");
                } else if (max % 5 == 0) {
                    bw.write("Buzz");
                } else if (max % 3 == 0) {
                    bw.write("Fizz");
                } else {
                    bw.write(max + "\n");
                }
                break;
        }


        bw.flush();
        bw.close();
        br.close();

    }
}
