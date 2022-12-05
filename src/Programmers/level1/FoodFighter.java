package Programmers.level1;

public class FoodFighter {
    private String answer = "";

    public String solution(int[] food) {
        food = makeEven(food);
        firstChallenger(food);
        answer += "0";
        secondChallenger(food);
        return answer;
    }

    public int[] makeEven(int[] food) {
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 != 0) {
                food[i] = food[i] - 1;
            }
        }
        return food;
    }

    public void firstChallenger(int[] food) {
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i]/2; j++) {
                answer += String.valueOf(i);
            }
        }
    }

    public void secondChallenger(int[] food) {
        for (int i = food.length-1; i > 0; i--) {
            for (int j = 0; j < food[i]/2; j++) {
                answer += String.valueOf(i);
            }
        }
    }
}
/**
 * 회의 공정성을 위해 두 선수가 먹는 음식의 종류와 양이 같아야 하며,
 * 음식을 먹는 순서도 같아야 합니다
 * 이번 대회부터는 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치
 * 사용하지 못하는 음식도 존재함
 * 0은 물
 * 짝수가 아니라면 하나는 못쓰는 음식임
 */
