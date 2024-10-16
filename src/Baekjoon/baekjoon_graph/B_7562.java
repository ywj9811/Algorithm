package Baekjoon.baekjoon_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_7562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int size = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();
            Node start = new Node(x, y);

            int goalX = sc.nextInt();
            int goalY = sc.nextInt();
            Node goal = new Node(goalX, goalY);

            ChessBoard chessBoard = new ChessBoard(size);
            Knight knight = new Knight(chessBoard);
            int result = knight.calCount(start, goal);
            System.out.println(result);
        }
    }
}

class ChessBoard { //단순히 체스판의 역할만 수행할 수 있도록 작성
    private final int size;
    private final boolean[][] visited;

    public ChessBoard(int size) {
        this.size = size;
        visited = new boolean[size][size];
    }

    public boolean isVisited(int x, int y) {
        return visited[x][y];
    }

    public void visit(int x, int y) {
        visited[x][y] = true;
    }

    public boolean checkBound(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}

class Knight { //나이트의 경우에 어떻게 이동할 수 있는지 작성 -> 여기에 visited를 추가하면 더욱 확장성이 있을 것으로 추측됨
    private int[] dx = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};
    private int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    private final ChessBoard chessBoard;

    public Knight(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int calCount(Node start, Node goal) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.getX() == goal.getX() && node.getY() == goal.getY())
                return node.getDepth();

            for (int i = 0; i < dx.length; i++) {
                if (chessBoard.checkBound(node.getX()+dx[i], node.getY()+dy[i])) {
                    if (chessBoard.isVisited(node.getX()+dx[i],node.getY()+dy[i]))
                        continue;
                    queue.add(new Node(node.getX()+dx[i], node.getY()+dy[i], node.getDepth()+1));
                    chessBoard.visit(node.getX()+dx[i], node.getY()+dy[i]);
                }
            }
        }
        return -1;
    }
}

class Node { // 말의 현재 좌표와 이동 숫자를 기록하는 용도
    private final int x;
    private final int y;
    private final int depth;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.depth = 0;
    }

    public Node(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDepth() {
        return depth;
    }
}