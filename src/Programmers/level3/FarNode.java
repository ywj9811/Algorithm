package Programmers.level3;

import java.util.*;

public class FarNode {
    public static void main(String[] args) {
        int solution = solution(4, new int[][]{{1,2},{2,3},{3,4}});
        System.out.println(solution);
    }

    public static int solution(int n, int[][] edge) {
        LinkedNode linkedNode = new LinkedNode(n);
        linkedNode.setNodes(edge);

        NodeManage nodeManage = new NodeManage(linkedNode);
        return nodeManage.getMostFarNodeCount();
    }
}

class LinkedNode {
    private List<Integer>[] nodes;

    public LinkedNode(int n) {
        this.nodes = new List[n+1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
    }

    public void setNodes (int[][] edge) {
        for (int[] connect : edge) {
            int start = connect[0];
            int end = connect[1];
            nodes[start].add(end);
            nodes[end].add(start);
        }
    }

    public List<Integer>[] getNodes() {
        return nodes;
    }
}

class NodeManage {
    private final LinkedNode linkedNode;
    private boolean visited[];
    private int results[];

    public NodeManage(LinkedNode linkedNode) {
        this.linkedNode = linkedNode;
        this.visited = new boolean[linkedNode.getNodes().length];
        this.results = new int[linkedNode.getNodes().length];
    }

    public int getMostFarNodeCount() {
        bfs();

        int max = 0;
        int cnt = 0;

        for (int result : results) {
            if (result > max) {
                max = result;
                cnt = 1;
                continue;
            }
            if (result == max) {
                cnt++;
            }
        }
        return cnt;
    }

    private void bfs() {
        List<Integer>[] nodes = linkedNode.getNodes();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        results[1] = 1;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int node : nodes[poll]) {
                if (visited[node])
                    continue;
                visited[node] = true;
                results[node] = results[poll]+1;
                queue.add(node);
            }
        }
    }
}