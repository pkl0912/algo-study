package programmers.retry;

import java.util.*;
public class Solution42583 {

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Deque<int[]> on = new ArrayDeque<>(); // {무게, 나가는 시각}
            Deque<Integer> wait = new ArrayDeque<>();
            for (int w : truck_weights) wait.offer(w);

            int time = 0;
            int bridgeWeight = 0;

            while (!on.isEmpty() || !wait.isEmpty()) {
                time++;

                // 1. 다리 끝에 도달한 트럭 제거
                if (!on.isEmpty() && on.peek()[1] == time) {
                    bridgeWeight -= on.poll()[0];
                }

                // 2. 대기 중인 트럭을 올릴 수 있는지 확인
                if (!wait.isEmpty()) {
                    int nextW = wait.peek();
                    if (bridgeWeight + nextW <= weight) {
                        wait.poll();
                        on.offer(new int[]{nextW, time + bridge_length});
                        bridgeWeight += nextW;
                    }
                }
            }

            return time;
        }
    }
}
