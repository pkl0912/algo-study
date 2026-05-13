package programmers;
import java.util.*;
public class Solution468379 {

    /**
     * 2차원 배열에서 특정 영역에 대한 최솟값 or 최댓값
     *
     * 2번의 sliding window를 사용해야함. -> deque를 사용가능. 누적값같은것을 사용하지 않고 맨 앞의 값만 사용하면 되기 때문.
     * todo 복기필요
     */
    class Solution {
        public int[] solution(int m, int n, int h, int w, int[][] drops) {
            final int INF = Integer.MAX_VALUE;

            int[][] time = new int[m][n];
            for (int i = 0; i < m; i++) Arrays.fill(time[i], INF);

            for (int i = 0; i < drops.length; i++) {
                int r = drops[i][0];
                int c = drops[i][1];
                time[r][c] = i + 1;
            }

            int cols = n - w + 1;
            int[][] rowMin = new int[m][cols];

            for (int r = 0; r < m; r++) {
                Deque<Integer> dq = new ArrayDeque<>();
                for (int c = 0; c < n; c++) {
                    while (!dq.isEmpty() && dq.peekFirst() <= c - w) dq.pollFirst();
                    while (!dq.isEmpty() && time[r][dq.peekLast()] >= time[r][c]) dq.pollLast();
                    dq.addLast(c);

                    if (c >= w - 1) {
                        rowMin[r][c - w + 1] = time[r][dq.peekFirst()];
                    }
                }
            }

            int bestTime = -1;
            int ansR = 0, ansC = 0;

            for (int c = 0; c < cols; c++) {
                Deque<Integer> dq = new ArrayDeque<>();
                for (int r = 0; r < m; r++) {
                    while (!dq.isEmpty() && dq.peekFirst() <= r - h) dq.pollFirst();
                    while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[r][c]) dq.pollLast();
                    dq.addLast(r);

                    if (r >= h - 1) {
                        int top = r - h + 1;
                        int curTime = rowMin[dq.peekFirst()][c];

                        if (curTime > bestTime ||
                                (curTime == bestTime && (top < ansR || (top == ansR && c < ansC)))) {
                            bestTime = curTime;
                            ansR = top;
                            ansC = c;
                        }
                    }
                }
            }

            return new int[]{ansR, ansC};
        }
    }

}
