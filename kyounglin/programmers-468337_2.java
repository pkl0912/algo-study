package kyounglin;

import java.util.*;
class Solution {
    class State implements Comparable<State> {
        int stage;
        int totalCost;
        int[] inventory;
        State(int stage, int totalCost, int[] inventory) {
            this.stage = stage;
            this.totalCost = totalCost;
            this.inventory = inventory;
        }
        @Override
        public int compareTo(State o) {
            return this.totalCost - o.totalCost;
        }
    }
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        PriorityQueue<State> pq = new PriorityQueue<>();

        pq.add(new State(0, 0, new int[n + 1]));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int[] curInventory = cur.inventory;
            int curCost = cur.totalCost;
            int curStage = cur.stage;

            if (cur.stage == n) return curCost;

            int idx = Math.min(curInventory[curStage], cost[curStage].length - 1);
            curCost += cost[curStage][idx];

            // 힌트 안 살 때
            pq.add(new State(curStage + 1, curCost, curInventory.clone()));

            // 힌트 살 때
            if(curStage<n-1){
                int[] boughtInventory = curInventory.clone();
                for (int i = 1; i < hint[curStage].length; i++) {
                    int hintStage = hint[curStage][i] - 1;
                    boughtInventory[hintStage]++;
                }
                pq.add(new State(curStage + 1, curCost + hint[curStage][0], boughtInventory));
                }
            
        }
        return -1;
    }
}