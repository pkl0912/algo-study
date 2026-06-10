package kyounglin;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight = 0; 
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int truckIndex = 0;

        while (truckIndex < truck_weights.length || currentWeight > 0) {
            answer++; 

            currentWeight -= bridge.poll();

            if (truckIndex < truck_weights.length) {
                if (currentWeight + truck_weights[truckIndex] <= weight) {
                    bridge.offer(truck_weights[truckIndex]);
                    currentWeight += truck_weights[truckIndex];
                    truckIndex++;
                } else {
                    bridge.offer(0);
                }
            }
        }

        return answer;
    }
}