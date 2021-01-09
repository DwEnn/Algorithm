package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackersRank {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long result = substrCount(N, s);
        System.out.println(result);

    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long result = 0;
        result = n;

        for (int i = 0; i < n - 1; i++) {
            char c1 = s.charAt(i);

            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);

                if (c1 == c2) {
                    result++;
                } else {
                    if (j + 1 <= n) {
                        if (comp(s.substring(i, j), s.substring(j + 1)))
                            result++;
                    }
                    break;
                }
            }
        }

        return result;
    }

    static boolean comp(String comp, String line) {
        if (line.length() >= comp.length()) {
            for (int i = 0; i < comp.length(); i++) {
                if (line.charAt(i) != comp.charAt(i))
                    return false;
            }
            return true;
        }

        return false;
    }

}
