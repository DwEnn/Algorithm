package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSEx {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());

        DFSGraph dfsGraph = new DFSGraph(nV);

        // 그래프에 정점과 간선 입력
        // 입력받은 간선의 개수만큼 반복 ( ex. 정점 8, 간선 10 )
        dfsGraph.put(1, 2);
        dfsGraph.put(1, 3);
        dfsGraph.put(2, 4);
        dfsGraph.put(2, 5);
        dfsGraph.put(3, 6);
        dfsGraph.put(3, 7);
        dfsGraph.put(4, 8);
        dfsGraph.put(5, 8);
        dfsGraph.put(6, 8);
        dfsGraph.put(7, 8);

        // 입력한 정점과 간선으로 구성된 인접행렬 출력
        dfsGraph.printGraphToAdsArr();

        /*
            정점 순서대로 그래프 탐색
         */
        for (int i = 1; i <= nV; i++) {
            System.out.println();
            System.out.print(String.format("정점 %d 부터 탐색 : ", i));
            dfsGraph.clearVisitArr();
//            dfsGraph.dfs(i);
            dfsGraph.bfs(i);
        }
    }

}

class DFSGraph {
    private int nV;
    private int [][] dfsGraph;
    private boolean[] visitArr;

    DFSGraph(int nV) {
        this.nV = nV;
        this.dfsGraph = new int[this.nV+1][this.nV+1];
        this.visitArr = new boolean[this.nV+1];
    }

    /**
     * 그래프 리
     */
    int[][] getGraph() {
        return this.dfsGraph;
    }

    /**
     * 그래프 추가 ( 양방향 )
     */
    void put(int x, int y) {
        this.dfsGraph[x][y] = this.dfsGraph[y][x] = 1;
    }

    /**
     * 그래프 추가 ( 단방향 )
     */
    void putSingle(int x, int y) {
        this.dfsGraph[x][y] = 1;
    }

    /*
        그래프 출력 ( 인접 행렬 )
     */
    void printGraphToAdsArr() {
        for (int i = 0; i < this.dfsGraph.length; i++) {
            for (int j = 0; j < this.dfsGraph[i].length; j++) {
                System.out.print(" " + this.dfsGraph[i][j]);
            }
            System.out.println();
        }
    }

    /*
        정점 방문 여부 확인 배열 초기화
     */
    void clearVisitArr() {
        for (int i = 0; i < this.visitArr.length; i++) {
            this.visitArr[i] = false;
        }
    }

    /*
        그래프 탐색 ( 재귀호출 )
     */
    void dfs(int vIdx) {
        // dfs() 에 들어온 vIdx 는 방문한 것이므로
        // 방문 배열의 해당 index 값을 true 로 바꿔주고 값을 출력
        this.visitArr[vIdx] = true;
        System.out.print(vIdx + " ");

        // 인접 행렬로 구현된 그래프에서
        // 정점의 개수(nV) 만큼 탐색
        for (int i = 1; i <= this.nV; i++) {
            // dfsGraph[][] 의 해당 정점이 연결되어있는 것으로 표시되어 있으나 ( 연결은 1로 표시 )
            // 방문 배열에서 방문하지 않은 상태 ( false ) 인 경우
            if (dfsGraph[vIdx][i] == 1 && !visitArr[i])
                dfs(i);
        }
    }

    void bfs(int vIdx) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vIdx);
        visitArr[vIdx] = true;

        while (!queue.isEmpty()) {
            vIdx = queue.poll();
            System.out.print(vIdx + " ");

            for (int i = 1; i <= this.nV; i++) {
                if (dfsGraph[vIdx][i] == 1 && !visitArr[i]) {
                    queue.add(i);
                    visitArr[i] = true;
                }
            }
        }

    }


}
