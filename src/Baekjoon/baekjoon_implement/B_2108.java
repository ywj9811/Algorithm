package Baekjoon.baekjoon_implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Value> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            Optional<Integer> first = numbers.stream()
                    .filter(number -> number.number == input)
                    .map(number -> number.count++)
                    .findFirst();
            if (first.isEmpty())
                numbers.add(new Value(input));
        }

        Collections.sort(numbers, new Comparator<Value>() {
            @Override
            public int compare(Value o1, Value o2) {
                return o1.number - o2.number;
            }
        });

        int sum = numbers.stream()
                .mapToInt(number -> number.number * number.count)
                .sum();
        System.out.println(Math.round(sum/n)); //산술평균


        int idx = (n/2) + 1;
        for (int i = 0; i < numbers.size(); i++) {
            Value value = numbers.get(i);
            idx -= value.count;
            if (idx <= 0) {
                System.out.println(value.number);
                break;
            }
        }

        Collections.sort(numbers, new Comparator<Value>() {
            @Override
            public int compare(Value o1, Value o2) {
                if (o1.count > o2.count)
                    return 1;
                if (o1.count == o2.count)
                    return o1.number - o2.number;
                return 0;
            }
        });

        if (numbers.get(0).count == numbers.get(1).count) { // 최빈값
            System.out.println(numbers.get(1).number);
        } else {
            System.out.println(numbers.get(0).number);
        }

        System.out.println(numbers.get(numbers.size()-1).number - numbers.get(0).number); //범위
    }

    private static class Value {
        public Value(int number) {
            this.number = number;
            this.count = 1;
        }
        int number;
        int count;
    }
}
