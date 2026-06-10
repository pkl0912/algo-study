package kyounglin;
import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        final int INF = Integer.MAX_VALUE;
        int[][] grid = new int[m][n];
        for (int[] row : grid) Arrays.fill(row, INF);   
        for (int i = 0; i < drops.length; i++)
            grid[drops[i][0]][drops[i][1]] = i + 1;      

        int outW = n - w + 1;

        int[][] rowMin = new int[m][outW];
        for (int r = 0; r < m; r++) {
            Deque<Integer> dq = new ArrayDeque<>();        
            for (int c = 0; c < n; c++) {
                while (!dq.isEmpty() && grid[r][dq.peekLast()] >= grid[r][c]) dq.pollLast();
                dq.addLast(c);
                if (dq.peekFirst() <= c - w) dq.pollFirst();
                if (c >= w - 1) rowMin[r][c - w + 1] = grid[r][dq.peekFirst()];
            }
        }

        int best = -1, bx = 0, by = 0;                    
        for (int j = 0; j < outW; j++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int r = 0; r < m; r++) {
                while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[r][j]) dq.pollLast();
                dq.addLast(r);
                if (dq.peekFirst() <= r - h) dq.pollFirst();
                if (r >= h - 1) {
                    int i = r - h + 1;
                    int firstRain = rowMin[dq.peekFirst()][j];   
                    if (firstRain > best ||
                        (firstRain == best && (i < bx || (i == bx && j < by)))) {
                        best = firstRain; bx = i; by = j;        
                    }
                }
            }
        }
        return new int[]{bx, by};
    }
}
