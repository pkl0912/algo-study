import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;

    public int solution(int[][] beginning, int[][] target) {
        int n = beginning.length;
        int m = beginning[0].length;

        dfs(0, n + m, 0, beginning, target);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(int depth, int total, int cnt,
                    int[][] board, int[][] target) {

        if (depth == total) {

            boolean same = true;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != target[i][j]) {
                        same = false;
                        break;
                    }
                }

                if (!same) break;
            }

            if (same) {
                min = Math.min(min, cnt);
            }

            return;
        }

        int n = board.length;
        int m = board[0].length;

        // 현재 행 또는 열을 뒤집지 않는 경우
        dfs(depth + 1, total, cnt, board, target);

        // 현재 행 또는 열을 뒤집는 경우
        if (depth < n) {
            turn(board, depth, true);
        } else {
            turn(board, depth - n, false);
        }

        dfs(depth + 1, total, cnt + 1, board, target);

        // 원상복구
        if (depth < n) {
            turn(board, depth, true);
        } else {
            turn(board, depth - n, false);
        }
    }

    public void turn(int[][] board, int idx, boolean row) {
        int n = board.length;
        int m = board[0].length;

        if (row) {
            for (int j = 0; j < m; j++) {
                board[idx][j] ^= 1;
            }
        } else {
            for (int i = 0; i < n; i++) {
                board[i][idx] ^= 1;
            }
        }
    }
}