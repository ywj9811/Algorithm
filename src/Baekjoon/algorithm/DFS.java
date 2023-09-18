package Baekjoon.algorithm;

// 표에서 ~로 이루어진 개수 등등

public class DFS {

    static int n = 4, m = 5;
    static int[][] graph =   {
            {0, 0, 1, 1, 0}
            ,{0, 0, 0, 1, 1}
            ,{1, 1, 1, 1, 1}
            ,{0, 0, 0, 0, 0}
    };
    // 0으로 이루어진 것만 아이스크림을 만들 수 있다. 1은 안뚫린 것

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            // 이를 통해 연결된 모든 것들을 이제 1로 처리하여 구멍모음을 한묶음으로 처리
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    //0을 만나면 dfs에서 자신 포함 주변의 연결된 0을 모두 1로 바꾸게 됨
                    //0과 연결된 0은 처음 0을 진입했을 때 모두 1로 변경했기 때문에, 연결안된 0을 만날때까지 모두 False반환
                    //새로운 떨어진 0을 만나면 다시 반복 -> 이때만 result+1;
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력
    }
}
