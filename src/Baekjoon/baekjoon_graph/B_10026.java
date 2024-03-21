package Baekjoon.baekjoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_10026 {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static Queue<Node> queue;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[][] r;
    private static int[][] g;
    private static int[][] b;
    private static int[][] rg;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static int n;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] input = s.split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j];
            }
        }

        getRedCount();
        getGreenCount();
        getBlueCount();

        int generalCount = count;
        count = 0;
        getRedGreenCount();
        getBlueCount();

        System.out.println(generalCount + " " + count);
    }

    private static int getRedCount() {
        r = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("R")) {
                    r[i][j] = 1;
                    continue;
                }
                r[i][j] = 0;
                visited[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j])
                    redBfs(i,j);
            }
        }
        return count;
    }

    private static int redBfs(int startX, int startY) {
        count++;
        queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (
                        (now.x + dx[i]) >= 0 && now.y + dy[i] >= 0 &&
                                (now.x + dx[i]) < n && now.y + dy[i] < n &&
                                !visited[now.x + dx[i]][now.y + dy[i]]
                ) {
                    queue.add(new Node(now.x + dx[i], now.y + dy[i]));
                    visited[now.x + dx[i]][now.y + dy[i]] = true;
                }
            }
        }
        return count;
    }

    private static int getGreenCount() {
        g = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("G")) {
                    g[i][j] = 1;
                    continue;
                }
                g[i][j] = 0;
                visited[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j])
                    greenBfs(i,j);
            }
        }
        return count;
    }

    private static int greenBfs(int startX, int startY) {
        count++;
        queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (
                        (now.x + dx[i]) >= 0 && now.y + dy[i] >= 0 &&
                                (now.x + dx[i]) < n && now.y + dy[i] < n &&
                                !visited[now.x + dx[i]][now.y + dy[i]]
                ) {
                    queue.add(new Node(now.x + dx[i], now.y + dy[i]));
                    visited[now.x + dx[i]][now.y + dy[i]] = true;
                }
            }
        }
        return count;
    }

    private static int getBlueCount() {
        b = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("B")) {
                    b[i][j] = 1;
                    continue;
                }
                b[i][j] = 0;
                visited[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j])
                    blueBfs(i,j);
            }
        }
        return count;
    }

    private static int blueBfs(int startX, int startY) {
        count++;
        queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (
                        (now.x + dx[i]) >= 0 && now.y + dy[i] >= 0 &&
                                (now.x + dx[i]) < n && now.y + dy[i] < n &&
                                !visited[now.x + dx[i]][now.y + dy[i]]
                ) {
                    queue.add(new Node(now.x + dx[i], now.y + dy[i]));
                    visited[now.x + dx[i]][now.y + dy[i]] = true;
                }
            }
        }
        return count;
    }

    private static int getRedGreenCount() {
        rg = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("R") || map[i][j].equals("G")) {
                    rg[i][j] = 1;
                    continue;
                }
                rg[i][j] = 0;
                visited[i][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j])
                    redGreenBfs(i,j);
            }
        }
        return count;
    }

    private static int redGreenBfs(int startX, int startY) {
        count++;
        queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (
                        (now.x + dx[i]) >= 0 && now.y + dy[i] >= 0 &&
                                (now.x + dx[i]) < n && now.y + dy[i] < n &&
                                !visited[now.x + dx[i]][now.y + dy[i]]
                ) {
                    queue.add(new Node(now.x + dx[i], now.y + dy[i]));
                    visited[now.x + dx[i]][now.y + dy[i]] = true;
                }
            }
        }
        return count;
    }
}
