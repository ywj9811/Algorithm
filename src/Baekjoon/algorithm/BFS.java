package Baekjoon.algorithm;

import java.util.LinkedList;
import java.util.Queue;

// 미로찾기와 같은 경우, 나가는데 걸리는 시간 구하기 등등

public class BFS {
    static int n = 3, m = 3;
    static int[][] graph = {
            {1, 1, 0}
            ,{0, 1, 0}
            ,{0, 1, 1}
    };

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int bfs(int x, int y) {
        // 시작할 위치 x, y 입력받음
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        // 큐가 빌 때까지 반복하기
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0)
                    continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    // 현재의 위치까지 오는데 최소의 시간이 기록되게 됨 (Queue를 통해 하였기 때문에 이번 접근이 최초 접근임)
                    // 따라서 만약 1인 경우 아직 접근한 것이 아님
                    q.offer(new Node(nx, ny));
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) {
        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }

}

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
