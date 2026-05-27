package programmers;
import java.util.*;
public class Solution42583 {

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            int bridgeWeight = 0;
            Deque<Integer> onBridgeTrucks = new ArrayDeque<>();
            Deque<Integer> waitingTrucks = new ArrayDeque<>();

            for(int t : truck_weights){
                waitingTrucks.offer(t);
            }

            // 다리를 0으로 채움
            for(int i=0; i<bridge_length; i++){
                onBridgeTrucks.offer(0);
            }

            while(true){

                // 1. 무조건 한 칸 이동
                int outTruck = onBridgeTrucks.pollFirst();
                bridgeWeight -= outTruck;

                // 2. 종료 조건
                if(waitingTrucks.isEmpty() && bridgeWeight == 0){
                    answer++;
                    break;
                }

                // 3. 트럭 올릴 수 있는지
                if(!waitingTrucks.isEmpty() &&
                        bridgeWeight + waitingTrucks.peekFirst() <= weight){

                    int currentTruckW = waitingTrucks.pollFirst();
                    onBridgeTrucks.offerLast(currentTruckW);
                    bridgeWeight += currentTruckW;

                } else {
                    onBridgeTrucks.offerLast(0);
                }

                // 시간 +1
                answer++;
            }

            return answer;
        }
    }
}
