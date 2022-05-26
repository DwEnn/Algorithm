package baekjoon;

import java.util.Scanner;

public class B1012 {

    private static int T, N, M, K, map[][];
    private static boolean[][] visited;
    public static int max = -1;
    private static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            M = in.nextInt();
            N = in.nextInt();
            K = in.nextInt();

            int cnt = 0;

            map = new int[M][N];
            visited = new boolean[M][N];

            for(int i = 0; i < K; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                map[x][y] = 1;
            }

            for (int i = 0; i < M ; i++) {
                for (int j = 0; j < N ; j++) {
                    if (map[i][j] == 1&&!visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);

                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    public static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny)&& !visited[nx][ny]&&map[nx][ny]==1) {
                visited[nx][ny] = true;
                dfs(nx,ny);
            }

        }

    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

}