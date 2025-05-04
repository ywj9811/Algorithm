package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManhattanDistance {
    public void main(String[] args) {
        String[][] places = new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] solution = solution(places);

        Arrays.stream(solution).forEach(System.out::println);
    }

    private int[] solution(String[][] places) {
        String person = "P";

        String[][] board;
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] place = places[i];
            board = new String[5][5];
            List<Person> people = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String row = place[j];
                String[] split = row.split("");
                for (int k = 0; k < 5; k++) {
                    String temp = split[k];
                    board[k][j] = temp;
                    if (temp.equals(person))
                        people.add(new Person(k, j));
                }
            }
            answer[i] = check(people, board);
        }

        return answer;
    }

    private int check(List<Person> people, String[][] board) {
        for (int i = 0; i < people.size()-1; i++) {
            Person person = people.get(i);
            int x = person.x;
            int y = person.y;
            for (int j = i+1; j < people.size(); j++) {
                Person target = people.get(j);
                int temp = Math.abs(x - target.x) + Math.abs(y - target.y);
                if (temp < 2)
                    return 0;
                if (temp == 2) {
                    int minX = Math.min(x, target.x);
                    int minY = Math.min(y, target.y);

                    for (int checkX = minX; checkX <= minX + Math.abs(x - target.x); checkX++) {
                        for (int checkY = minY; checkY <= minY + Math.abs(y - target.y); checkY++) {
                            System.out.println("checkX : " + checkX);
                            System.out.println("checkY : " + checkY);
                            if (board[checkX][checkY].equals("O"))
                                return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

    private class Person {
        int x, y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
