package Baekjoon.baekjoon_graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class B_4195 {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, String> parent;
    private static Map<String, Integer> size;

    public static void main(String[] args) {
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            int n = sc.nextInt();
            parent = new HashMap<>();
            size = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String a = sc.next();
                String b = sc.next();
                System.out.println(union(a, b));
            }
        }
    }

    private static int union(String a, String b) {
        /**
         * a, b를 아직 갖지 않았다면 처음으로 union을 진행하는 것 -> 해당 key에 본인을 넣어줌. 그리고 size는 하나뿐이니 1을 넣어줌
         */
        if (!parent.containsKey(a)) {
            parent.put(a, a);
            size.put(a, 1);
        }
        if (!parent.containsKey(b)) {
            parent.put(b, b);
            size.put(b, 1);
        }

        /**
         * a, b 각각에 대해 루트를 찾음 그리고, 모든 부모들의 루트를 통일함
         * 만약 rootA와 rootB가 같지 않다면 이제는 rootA와 rootB가 연결되는 단계로 진입하는 것으로, rootB의 부모를 rootA의 부모로 통일
         * 그리고, rootA의 size는 rootB의 size를 더해서 새롭게 합쳐지는 size를 얻어냄
         * 그렇게 반환
         */
        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootB, rootA);
            size.put(rootA, size.get(rootA) + size.get(rootB));
        }

        return size.get(find(a));
    }

    private static String find(String x) {
        /**
         * 만약 x의 부모가 x가 아니라면, 본인이 루트가 아님.
         * 따라서 x의 값에 루트 부모를 넣어줘야 함.
         * x의 부모를 쭉 타고 올라가서 최종 루트 부모를 찾으며 그 사이에 루트 부모로 모두 통일시키도록 함.
         * x의 부모를 루트 부모로 지정한 이후 find종료
         */
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }
}
