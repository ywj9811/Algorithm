package Baekjoon.baekjoon_datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_10866 {
    /**
     * push_front X : 정수 X를 덱의 앞에 넣는다.
     * push_back X : 정수 X를 덱의 뒤에 넣는다.
     * pop_front : 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력
     * 만약 덱에 아무것도 없다면 -1을 출력
     * size: 덱에 들어있는 정수의 개수 출력
     * empty : 덱이 비어있으면 1 아니면 0 출력
     * front : 덱의 가장 앞 출력 , 없다면 -1
     * back //
     *
     * 명령의 수 입력
     * 명령 입력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int value;
        String orderAndInt;
        String[] s;

        List<Integer> deque = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            orderAndInt = br.readLine();
            s = orderAndInt.split(" ");

            switch (s[0]) {
                case "push_front" :
                    value = Integer.parseInt(s[1]);
                    deque.add(0, value);
                    break;
                case "push_back" :
                    value = Integer.parseInt(s[1]);
                    deque.add(value);
                    break;
                case "pop_front" :
                    if (checkEmpty(deque, -1)) {
                        break;
                    }
                    System.out.println(deque.get(0));
                    deque.remove(0);
                    break;
                case "pop_back" :
                    if (checkEmpty(deque, -1)) {
                        break;
                    }
                    System.out.println(deque.get(deque.size()-1));
                    deque.remove(deque.size()-1);
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    if (checkEmpty(deque, 1)) {
                        break;
                    }
                    System.out.println(0);
                    break;
                case "front" :
                    if (checkEmpty(deque, -1)) {
                        break;
                    }
                    System.out.println(deque.get(0));
                    break;
                case "back" :
                    if (checkEmpty(deque, -1)) {
                        break;
                    }
                    System.out.println(deque.get(deque.size()-1));
                    break;
            }
        }
    }

    private static boolean checkEmpty(List<Integer> checkList, int print) {
        if (checkList.isEmpty()) {
            System.out.println(print);
            return true;
        }
        return false;
    }
}
