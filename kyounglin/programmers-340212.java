package kyounglin;
import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int max =0;
        for(int diff : diffs){
            max = Math.max(max,diff);
        }
        int lt = 1;
        int rt = max;
        while(lt<=rt){
            int mid = (lt+rt) /2;
            if(isPossible(mid, diffs, times, limit)){
                answer = Math.min(answer, mid);
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        return answer;
    }
    public boolean isPossible(int level, int[] diffs, int[] times, long limit){
        long sum = 0;
        for(int i = 0; i<diffs.length; i++){
            int diff = diffs[i];
            int timeCur = times[i];
            int timePrev = i==0 ? 0 : times[i-1];
            if(diff>level){
                sum+= (diff-level) * (timeCur+timePrev) + timeCur;
            }else{
                sum+= timeCur;
            }
            if(sum>limit) return false;
        }
        return true;
    }
}