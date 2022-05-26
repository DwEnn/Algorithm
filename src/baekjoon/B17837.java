package baekjoon;//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class B17837 {
//
//    private static final int WHITE = 0;
//    private static final int RED = 1;
//    private static final int BLUE = 2;
//
//    private static final int RIGHT = 1;
//    private static final int LEFT = 2;
//    private static final int TOP = 3;
//    private static final int BOTTOM = 4;
//
//    private static int backjoon.N, K;
//    private static int[][] board;
//    private static Chess[] chess;
//
//    private static ArrayList<ArrayList<Chess>> game;
//
//    // 쌓이는 말을 담아두는 리스트
//    private static ArrayList<ArrayList<Chess>> stack;
//
//    public static void backjoon.main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        backjoon.N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        board = new int[backjoon.N][backjoon.N];
//        chess = new Chess[K];
//
//        for (int i = 0; i < board.length; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < board[i].length; j++) {
//                board[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < chess.length; i++) {
//            st = new StringTokenizer(br.readLine());
//            Chess c = new Chess();
//            c.row = Integer.parseInt(st.nextToken());
//            c.column = Integer.parseInt(st.nextToken());
//            c.direction = Integer.parseInt(st.nextToken());
//            chess[i] = c;
//        }
//
//        int stage = 0;
//        while (checkMate(chess[0], chess[0], 0) != 3) {
//
//            for (int i = 0; i < chess.length; i++) {
//                whereToGo(chess[i]);
//            }
//
//
//            if (++stage == 1000) {
//                stage = -1;
//                break;
//            }
//        }
//
//        System.out.println(stage);
//    }
//
//    private static void move(Chess c, int moveToColor) {
//        switch (moveToColor) {
//            case WHITE:
//
//                break;
//            case RED:
//
//                break;
//            case BLUE:
//
//                break;
//        }
//    }
//
//    private static void movePoint(Chess c, int point) {
//        int toGo;
//        switch (point) {
//            case RIGHT:
//                toGo = c.row + 1;
//                if (toGo > backjoon.N + 1) {
//                    c.direction = LEFT;
//                    move(c, BLUE);
//                } else
//                    c.row = toGo;
//                break;
//            case LEFT:
//                toGo = c.row - 1;
//                if (toGo < 1) {
//                    c.direction = RIGHT;
//                    move(c, BLUE);
//                } else
//                    c.row = toGo;
//                break;
//            case TOP:
//                toGo = c.column - 1;
//                if (toGo < 1) {
//                    c.direction = BOTTOM;
//                    move(c, BLUE);
//                } else
//                    c.column = toGo;
//                break;
//            case BOTTOM:
//                toGo = c.column + 1;
//                if (toGo > backjoon.N + 1) {
//                    c.direction = TOP;
//                    move(c, BLUE);
//                } else
//                    c.column = toGo;
//                break;
//        }
//    }
//
//    private static Point whereToGo(Chess c) {
//        int toGo;
//        switch (c.direction) {
//            case RIGHT:
//                toGo = c.column + 1;
//                if (toGo > backjoon.N + 1)
//                    return new Point(c.row - 1, toGo - 2, BLUE);
//                return new Point(c.row - 1, toGo - 1, board[c.row - 1][toGo - 1]);
//            case LEFT:
//                toGo = c.row - 1;
//                if (toGo < 1)
//                    return BLUE;
//                return board[toGo - 1][c.column - 1];
//            case TOP:
//                toGo = c.column - 1;
//                if (toGo < 1) {
//                    return BLUE;
//                }
//                return board[c.row - 1][toGo - 1];
//
//            case BOTTOM:
//                toGo = c.column + 1;
//                if (toGo > backjoon.N + 1) {
//                    return BLUE;
//                }
//                return board[c.row - 1][toGo - 1];
//        }
//        return 0;
//    }
//
//
//    /**
//     * 말이 4개 올려져있는지 여부 확인
//     *
//     * @param c1  확인할 chess
//     * @param c2  이전 chess
//     * @param backjoon.cnt 올려진 말의 개수
//     * @return backjoon.cnt
//     */
//    private static int checkMate(Chess c1, Chess c2, int backjoon.cnt) {
//        if (c1.top != null && c1.top != c2) {
//            checkMate(c1.top, c1, ++backjoon.cnt);
//        } else if (c1.bottom != null && c1.top != c2) {
//            checkMate(c1.bottom, c2, ++backjoon.cnt);
//        }
//
//        return backjoon.cnt;
//    }
//
//}
//class Point {
//    int row;
//    int column;
//    int moveToColor;
//
//    public Point(int row, int column, int moveToColor) {
//        this.row = row;
//        this.column = column;
//        this.moveToColor = moveToColor;
//    }
//}
//
//class Chess {
//    Chess top;
//    Chess bottom;
//
//    int row;
//    int column;
//    int direction;
//}
