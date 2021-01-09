package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B4796 {

    private static final String END_INPUT = "0 0 0";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> input = new ArrayList<>();
        while (true) {
            String str = br.readLine();
            if (str.equals(END_INPUT))
                break;

            input.add(str);
        }

        int[] results = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            StringTokenizer st = new StringTokenizer(input.get(i));
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int num = V / P;
            results[i] = (num * L) + Math.min((V % P), L);
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println("Case " + (i + 1) + ": " + results[i]);
        }

    }

}
