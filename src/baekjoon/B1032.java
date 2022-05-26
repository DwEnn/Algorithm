package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1032 {

    private static final char DOT = '.';
    private static final char QM = '?';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        String extension = "";
        if (input[0].contains(Character.toString(DOT))) {
            try {
                extension = input[0].split("\\.")[1];
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }

        StringBuilder sb = new StringBuilder(input[0]);

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {

                char c = input[i].charAt(j);
                if (c == DOT) {
                    if (!extension.isEmpty()) {
                        try {
                            if (input[i].split("\\.")[1].equals(extension))
                                break;
                            else
                                extension = "";
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                    }
                }

                if (c != sb.charAt(j))
                    sb.replace(j, j + 1, Character.toString(QM));
            }
        }

        System.out.println(sb.toString());

//        another();
    }

    private static void another() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder(input[0]);

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {

                char c = input[i].charAt(j);

                if (c != sb.charAt(j))
                    sb.replace(j, j + 1, Character.toString(QM));
            }
        }

        System.out.println(sb.toString());
    }

}
