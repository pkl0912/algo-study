import java.util.*;

class Solution {

    List<List<String>> answer = new ArrayList<>();

    boolean[] col;
    boolean[] diagonal1;
    boolean[] diagonal2;

    char[][] board;

    public List<List<String>> solveNQueens(int n) {

        board = new char[n][n];
        col = new boolean[n];

        diagonal1 = new boolean[2 * n];
        diagonal2 = new boolean[2 * n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtracking(0, n);

        return answer;
    }

    private void backtracking(int row, int n) {

        if (row == n) {
            List<String> result = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                result.add(new String(board[i]));
            }

            answer.add(result);
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c]) {
                continue;
            }

            int d1 = row - c + n;
            int d2 = row + c;

            if (diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            board[row][c] = 'Q';
            col[c] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            backtracking(row + 1, n);

            board[row][c] = '.';
            col[c] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}