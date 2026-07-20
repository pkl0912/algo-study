package kyounglin;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b)-> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        int time = 0;
        int answer = 0;
        int idx = 0;
        while(idx<jobs.length || !pq.isEmpty()){
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.add(jobs[idx]);
                idx++;
            }
            if(pq.isEmpty()){
                time = jobs[idx][0];
                continue;
            }
            int[] cur = pq.poll();
            int a = cur[0];
            int b = cur[1];
            time+=b;
            answer += (time-a);
        }
        return answer/jobs.length;
    }
}