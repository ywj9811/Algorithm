package Programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class TicTacTo {
    public static void main(String[] args) {
    }
    public int solution(String[] board) {
        List<Integer> isO = new ArrayList<>();
        List<Integer> isX = new ArrayList<>();

        int cnt = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < 3; j++) {
                char is = board[i].charAt(j);
                if(is == 'O') {
                    isO.add(cnt);
                    cnt++;
                    continue;
                }
                if(is == 'X') {
                    isX.add(cnt);
                    cnt++;
                    continue;
                }
                cnt++;
            }
        }

        if(isX.size() > isO.size() || isO.size() > isX.size()+1) {
            return 0;
        }
        if(check(isO)) {
            if(check(isX)) {
                return 0;
            }
            if(isO.size() == isX.size()) {
                return 0;
            }
        }
        if(check(isX)) {
            if(isO.size() > isX.size())
                return 0;
        }

        int answer = 1;
        return answer;
    }

    boolean check(List<Integer> checkList) {
        if(checkList.contains(0) && checkList.contains(1) && checkList.contains(2))
            return true;
        if(checkList.contains(3) && checkList.contains(4) && checkList.contains(5))
            return true;
        if(checkList.contains(6) && checkList.contains(7) && checkList.contains(8))
            return true;
        if(checkList.contains(0) && checkList.contains(4) && checkList.contains(8))
            return true;
        if(checkList.contains(2) && checkList.contains(4) && checkList.contains(6))
            return true;
        if(checkList.contains(0) && checkList.contains(3) && checkList.contains(6))
            return true;
        if(checkList.contains(1) && checkList.contains(4) && checkList.contains(7))
            return true;
        if(checkList.contains(2) && checkList.contains(5) && checkList.contains(8))
            return true;
        return false;
    }
}
