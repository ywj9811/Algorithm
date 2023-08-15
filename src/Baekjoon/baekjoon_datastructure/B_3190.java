package Baekjoon.baekjoon_datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class B_3190 {
    static boolean[][] map;
    static boolean[][] apples;
    static boolean stop = false;
    static int n;
    static int k;
    static int dir = 1;
    static int time = 0;
    static Deque<Current> now = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = parseInt(br.readLine());
        k = parseInt(br.readLine());

        map = new boolean[n+1][n+1];
        apples = new boolean[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(map[i], false);
            Arrays.fill(apples[i], false);
        }
        now.add(new Current(1, 1));

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            apples[parseInt(st.nextToken())][parseInt(st.nextToken())] = true;
        }

        int loop = parseInt(br.readLine());
        int timer = 0;
        String lr = "";
        for (int i = 0; i < loop; i++) {
            if (stop) {
                System.out.println(time);
                return;
            }
            st = new StringTokenizer(br.readLine());
            timer = Integer.parseInt(st.nextToken()) - time;
            lr = st.nextToken();

            if (lr.equals("D"))
                right(timer);
            else
                left(timer);
        }
        if (stop) {
            System.out.println(time);
            return;
        }
        if (lr.equals("D"))
            right(100);
        else
            left(100);
        System.out.println(time);
    }

    static void right(int timer) {
        switch (dir) {
            case 1 :
                // 오른쪽 바라볼 때 작업 -> 끝날 때 아래쪽 바라보도록
                if (lookRIght(timer))
                    break;
                dir = 4;
                break;
            case 2 :
                // 위쪽 바라볼 때 작업 끝날 때 오른쪽 바라보도록
                if (lookTop(timer))
                    break;
                dir = 1;
                break;
            case 3 :
                // 왼쪽 바라볼 떄 작업 -> 끝날 때 위에 바라보도록
                if (lookLeft(timer))
                    break;
                dir = 2;
                break;
            case 4 :
                // 아래쪽 바라볼 때 작업 -> 끝에는 왼쪽 바라보도록
                if (lookBottom(timer))
                    break;
                dir = 3;
                break;
        }
    }

    static void left(int timer) {
        switch (dir) {
            case 1 :
                // 오른쪽 바라볼 때 작업 -> 끝날 때 위
                if (lookRIght(timer))
                    break;
                dir = 2;
                break;
            case 2 :
                // 위쪽 바라볼 때 작업 끝날 때 왼쪽
                if (lookTop(timer))
                    break;
                dir = 3;
                break;
            case 3 :
                // 왼쪽 바라볼 떄 작업 -> 끝날 때 아래쪽
                if (lookLeft(timer))
                    break;
                dir = 4;
                break;
            case 4 :
                // 아래쪽 바라볼 때 작업 -> 끝에는 오른쪽
                if (lookBottom(timer))
                    break;
                dir = 1;
                break;
        }
    }

    private static boolean lookBottom(int timer) {
        for (int i = 0; i < timer; i++) {
            time++;
            Current current = now.getLast();
            if (n < current.getA()+1  || (isContain(current.getA()+1, (current.getB())))) {
                stop = true;
                return true;
            }
            if (apples[current.getA()+1][current.getB()]) {
                now.add(new Current(current.getA()+1, current.getB()));
                apples[current.getA()+1][current.getB()] = false;
                continue;
            }
            now.poll();
            now.add(new Current(current.getA()+1, current.getB()));
        }
        return false;
    }

    private static boolean lookLeft(int timer) {
        for (int i = 0; i < timer; i++) {
            time++;
            Current current = now.getLast();
            if (0 >= current.getB()-1  || (isContain(current.getA(), (current.getB()-1)))) {
                stop = true;
                return true;
            }
            if (apples[current.getA()][current.getB()-1]) {
                now.add(new Current(current.getA(), current.getB()-1));
                apples[current.getA()][current.getB()-1] = false;
                continue;
            }
            now.poll();
            now.add(new Current(current.getA(), current.getB()-1));
        }
        return false;
    }

    private static boolean lookTop(int timer) {
        for (int i = 0; i < timer; i++) {
            time++;
            Current current = now.getLast();
            if (0 >= current.a-1  || (isContain(current.getA()-1, (current.getB())))) {
                stop = true;
                return true;
            }
            if (apples[current.getA()-1][current.getB()]) {
                now.add(new Current(current.getA()-1, current.getB()));
                apples[current.getA()-1][current.getB()] = false;
                continue;
            }
            now.poll();
            now.add(new Current(current.getA()-1, current.getB()));
        }
        return false;
    }

    private static boolean lookRIght(int timer) {
        for (int i = 0; i < timer; i++) {
            time++;
            Current current = now.getLast();
            if (n < current.getB()+1 || (isContain(current.getA(), (current.getB()+1)))) {
                stop = true;
                return true;
            }
            if (apples[current.a][current.getB()+1]) {
                now.add(new Current(current.a, current.getB()+1));
                apples[current.a][current.getB()+1] = false;
                continue;
            }
            now.poll();
            now.add(new Current(current.a, current.getB()+1));
        }
        return false;
    }

    // 큐에 이미 동일한 좌표의 Current 객체가 있는지 확인하는 메서드
    static boolean isContain(int a, int b) {
        for (Current c : now) {
            if (c.getA() == a && c.getB() == b) {
                return true;
            }
        }
        return false;
    }

    static class Current {
        public Current(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        int a;
        int b;
    }
}

