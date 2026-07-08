package kyounglin;

import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int d: diffs){
            min = Math.min(min, d);
            max = Math.max(max, d);
        }
        int lt = min; int rt = max;
        int answer = 0;
        while(lt<=rt){
            int mid = (lt+rt) /2;
            if(isPossible(mid, diffs, times, limit)){        
                answer = mid;
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        return answer;
    }
    public boolean isPossible(int level, int[] diffs, int[] times, long limit){
        int n = diffs.length;
        long sum = 0;
        for(int i = 0; i<n; i++){
            int diff = diffs[i];
            int time = times[i];
            int time_prev = i == 0 ? 0 : times[i-1];
            long cost = 0;
            if(diff<=level) cost = time;
            else cost = (long)(diff-level) * (time+time_prev) + time;
            sum+=cost;
        }
        if(sum<=limit) return true;
        return false;
    }
}