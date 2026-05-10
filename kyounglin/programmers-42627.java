package kyounglin;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b)-> a[0]-b[0]);
        int i = 0; 
        int cur = 0;
        int answer =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        
        while(i<jobs.length || !pq.isEmpty()){
            while(i<jobs.length && jobs[i][0]<=cur){
                pq.add(jobs[i]);
                i++;
            }
            if(pq.isEmpty()){
                cur = jobs[i][0];
            }else{
                int[] job = pq.poll();
                cur+=job[1];
                answer+= cur-job[0];
            }
        }
        return answer/jobs.length;
    }
}