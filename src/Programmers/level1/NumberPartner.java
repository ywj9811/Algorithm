package Programmers.level1;

public class NumberPartner {
    private int[] countX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] countY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private StringBuilder sb = new StringBuilder();
    private String answer;

    public String solution(String X, String Y) {
        addNumberToArray(X, Y);
        appendToBuilder();
        answer = sb.toString();
        valid();
        return answer;
    }
    public void addNumberToArray(String X, String Y) {
        for (int i = 0; i < X.length();i ++) {
            countX[Integer.parseInt(String.valueOf(X.charAt(i)))]++;
        }
        for (int i = 0; i < Y.length();i ++) {
            countY[Integer.parseInt(String.valueOf(Y.charAt(i)))]++;
        }
    }

    public void appendToBuilder() {
        for (int i = 9; i >= 0; i--) {
            if (countX[i] < countY[i]) {
                for (int j = 0; j < countX[i]; j++) {
                    sb.append(i);
                }
                continue;
            }
            for (int j = 0; j < countY[i]; j++) {
                sb.append(i);
            }
        }
    }

    public void valid() {
        if (answer.isEmpty())
            answer = "-1";
        if (answer.charAt(0) == '0')
            answer = "0";
    }
}
