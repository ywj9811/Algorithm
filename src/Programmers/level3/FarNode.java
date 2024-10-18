package Programmers.level3;

import java.util.*;

public class FarNode {
    public static void main(String[] args) {
        int solution = solution(4, new int[][]{{1,2},{2,3},{3,4}});
        System.out.println(solution);
    }

    public static int solution(int n, int[][] edge) {
        Node linkedNode = new LinkedNode(n);
        linkedNode.setNodes(edge);

        NodeManage nodeManage = new NodeManage(linkedNode);
        return nodeManage.getMostFarNodeCount();
    }
}

interface Node {
    void setNodes(int[][] edge);
    List<Integer> getNeighbor(int num);
    int getNodesSize();
}

class LinkedNode implements Node {
    private List<Integer>[] nodes;

    public LinkedNode(int n) {
        this.nodes = new List[n+1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
    }

    @Override
    public void setNodes (int[][] edge) {
        for (int[] connect : edge) {
            int start = connect[0];
            int end = connect[1];
            nodes[start].add(end);
            nodes[end].add(start);
        }
    }

    @Override
    public List<Integer> getNeighbor(int num) {
        return nodes[num];
    }

    @Override
    public int getNodesSize() {
        return nodes.length;
    }
}

class NodeManage {
    private final Node linkedNode;
    private boolean visited[];
    private int results[];

    public NodeManage(Node linkedNode) {
        this.linkedNode = linkedNode;
        this.visited = new boolean[linkedNode.getNodesSize()];
        this.results = new int[linkedNode.getNodesSize()];
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        results[1] = 1;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int node : linkedNode.getNeighbor(poll)) {
                if (visited[node])
                    continue;
                visited[node] = true;
                results[node] = results[poll]+1;
                queue.add(node);
            }
        }
    }
}