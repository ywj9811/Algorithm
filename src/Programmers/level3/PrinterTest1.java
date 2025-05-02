package Programmers.level3;
// 슬라이딩 윈도우 기법 개선할 필요가 있음 -> 추가되는 부분과 삭제되는 부분만 검샇하도록
public class PrinterTest1 {
    public static void main(String[] args) {
        int solution = solution(new int[][]{{0, 3}, {2, 1}}, new int[][]{{0, 3, 2, 1}, {0, 0, 0, 3}, {2, 1, 2, 1}});
        System.out.println(solution);
        solution = solution(new int[][]{{4,1,0}, {5,3,2}}, new int[][]{{5,0,2,5,5}, {3,3,5,1,3}, {0,3,2,2,3}, {2,1,3,0,1}});
        System.out.println(solution);
    }

    public static int solution(int[][] printer, int[][] paper) {
        Printer printerObject = new Printer(printer);
        Paper paperObject = new Paper(paper);
        PrintManager printManager = new PrintManager(paperObject, printerObject);
        return printManager.getStopCount();
    }
}

class PrintManager {
    private final Paper paper;
    private final Printer printer;

    public PrintManager(Paper paper, Printer printer) {
        this.paper = paper;
        this.printer = printer;
    }

    public int getStopCount(){
        int n = printer.getPrinterRow();
        int m = printer.getPrinterCol();
        int row = paper.getPaperRow();
        int col = paper.getPaperCol();

        return movePrinter(n, m, row, col);
    }

    private int movePrinter(int n, int m, int row, int col) {
        int stopCount = 0;
        boolean right = true;

        //최하단 좌표
        int x = 0;
        int y = 0;

        while (x < row + (n - 1)) {
            if (checkMatch(x, y)) {
                stopCount++;
            }

            if (right) {
                if (y + 1 < col + (m - 1)) {
                    y++;
                    continue;
                }
                x++;
                right = false;
                continue;
            }
            if (y > 0) {
                y--;
                continue;
            }
            x++;
            right = true;

        }
        return stopCount;
    }

    private boolean checkMatch(int x, int y) {
        boolean match = false;
        int n = printer.getPrinterRow();
        int m = printer.getPrinterCol();
        int row = paper.getPaperRow();
        int col = paper.getPaperCol();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (x - i >= 0 && x - i < row && y - j >= 0 && y - j < col) {
                    if (printer.getCoordinate(n-1-i, m-1-j) == paper.getCoordinate(x-i, y-j) && !paper.isVisited(x-i,y-j)) {
                        paper.addVisited(x-i, y-j);
                        match = true;
                    }
                }
            }
        }
        return match;
    }
}

class Paper {
    private int[][] board;
    private boolean[][] visited;

    public Paper(int[][] board) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
    }

    public int[][] getBoard() {
        return board;
    }

    public int getPaperRow() {
        return board.length;
    }

    public int getPaperCol() {
        return board[0].length;
    }

    public int getCoordinate(int row, int col) {
        return board[row][col];
    }

    public boolean isVisited(int row, int col) {
        return visited[row][col];
    }

    public void addVisited(int row, int col) {
        visited[row][col] = true;
    }
}

class Printer {
    private int[][] board;

    public Printer(int[][] board) {
        this.board = board;
    }

    public int getPrinterRow() {
        return board.length;
    }

    public int getPrinterCol() {
        return board[0].length;
    }

    public int getCoordinate(int row, int col) {
        return board[row][col];
    }
}