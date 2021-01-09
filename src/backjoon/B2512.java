package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] money = new int[N];
        String line = br.readLine();
        String[] lines = line.split("\\s+");
        int hi = 0;
        for (int i=0; i<N; i++) {
            money[i] = Integer.parseInt(lines[i]);
            hi = Math.max(hi, money[i]);
        }
        int M = Integer.parseInt(br.readLine());

        int lo = 0;
        while(lo+1 < hi) {
            int mid = (lo+hi)/2;

            int sum = 0;
            for (int m : money){
                sum += Math.min(m, mid);
            }

            if (sum > M)
                hi = mid;
            else
                lo = mid;

        }

        System.out.println(lo);
        br.close();
    }

}
