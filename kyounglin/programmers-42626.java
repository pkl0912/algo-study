package kyounglin;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: scoville){
            pq.add(s);
        }
        int answer = 0;
        while(pq.peek()<K && pq.size()>=2){
            int cur = pq.poll();
            int next = pq.poll();
            pq.add(cur+next*2);
            answer++;
        }
        
        return pq.peek()>=K ? answer : -1;
    }
}