package BJPrc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int sum = 0;
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
            sum+= numbers[i];
        }

        int avg = (int) Math.round((double) sum / N);
        bw.write(avg + "\n");

        Arrays.sort(numbers);

        bw.write(numbers[N/2] + "\n");

        Map<Integer,Integer> m = new HashMap<>();
        for(int n : numbers){
            m.put(n,m.getOrDefault(n,0)+ 1);
        }
        int maxCount = -1;
        int value = -1;
        for(int n : m.keySet()){
            if(m.get(n) > maxCount){
                maxCount = m.get(n);
            }
        }

        List<Integer> l = new ArrayList<>();

        for(int n : m.keySet()){
            if(m.get(n) == maxCount){
                l.add(n);
            }
        }
        Collections.sort(l);
        if(l.size() == 1){
            bw.write(l.get(0) + "\n");
        } else{
            bw.write(l.get(1) + "\n");
        }

        int range = numbers[N-1] - numbers[0];

        bw.write(range + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
