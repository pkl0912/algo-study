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
        
        Map<String, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.stage == n) {
                return cur.totalCost;
            }

            String stateKey = cur.stage + Arrays.toString(cur.inventory);
            if (visited.containsKey(stateKey) && visited.get(stateKey) <= cur.totalCost) continue;
            visited.put(stateKey, cur.totalCost);

            int currentHintCount = cur.inventory[cur.stage + 1];

            int useCount = Math.min(currentHintCount, n - 1);
            int solveCost = cost[cur.stage][useCount];

            int[] nextInvNoBundle = cur.inventory.clone();
            nextInvNoBundle[cur.stage + 1] = 0; 
            pq.add(new State(cur.stage + 1, cur.totalCost + solveCost, nextInvNoBundle));

    
            if (cur.stage < n - 1) {
                int[] nextInvWithBundle = cur.inventory.clone();
                nextInvWithBundle[cur.stage + 1] = 0;
                int bundlePrice = hint[cur.stage][0];
                for (int j = 1; j < hint[cur.stage].length; j++) {
                    int hintTarget = hint[cur.stage][j];
                    nextInvWithBundle[hintTarget]++;
                }
                pq.add(new State(cur.stage + 1, cur.totalCost + solveCost + bundlePrice, nextInvWithBundle));
            }
        }

        return -1;
    }
}