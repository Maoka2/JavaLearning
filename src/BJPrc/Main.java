package BJPrc;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        int[] temp = new int[N];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(nums[i]);
            result[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                result[stack.pop()] = temp[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
