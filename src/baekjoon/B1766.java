package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1766 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(b, a);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            int i = pq.poll();
            int num = map.getOrDefault(i, -1);
            if (num == -1)
                sb.append(i);
            else {
                pq.remove(num);
                sb.append(num).append(" ").append(i);
            }

            if (pq.isEmpty())
                break;
            else
                sb.append(" ");
        }

        System.out.println(sb.toString());

    }
}

