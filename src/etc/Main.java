package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 입력 받기
        String[] rowColStrArr = br.readLine().split(" ");
        int[] rowCol = {Integer.parseInt(rowColStrArr[0]), Integer.parseInt(rowColStrArr[1])};

        boolean[][] resultArr = new boolean[rowCol[0]][rowCol[1]];


        for (int i = 0; i < rowCol[0]; i++) {
            String temp = br.readLine();
            for (int j = 0; j < rowCol[1]; j++) {
                char tempChar = temp.charAt(j);
                boolean result = ((i + j) % 2 == 0 && tempChar == 'W') || ((i + j) % 2 == 1 && tempChar == 'B');

                resultArr[i][j] = result;
            }
        }

        int result = 64;

        for(int i = 0 ;  i <= rowCol[0] - 8 ; i++){
            for(int j =0 ; j <= rowCol[1] - 8 ; j++){
                int count =  checkCount(resultArr, i , j);
                if(result > count){
                    result = count;
                }
            }
        }
        System.out.println(result);

        br.close();
    }

    public static int checkCount (boolean[][] resultArr , int startRow , int startCol ){

        int count = 0;
        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8 ; j++) {
                if (resultArr[i][j]) count++;
            }
        }

        if (count > 64 - count) {
            count = (64 - count);
        }

        return count;
    }
}