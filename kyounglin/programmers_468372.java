package kyounglin;

import java.util.*;

class Solution {
    int answer = 1;

    public int solution(int dist_limit, int split_limit) {
        
        answer = 1;
        dfs(1, 1, 1, 0, dist_limit, split_limit);
        return answer;
    }
    //현재분배가능노드, 사용한 분배노드, 사용한 split, 확정 리프
    public void dfs(long cur, long used, long split, long leaf, int distLimit, int splitLimit){
        if(used>distLimit) return;
        
        answer = (int)Math.max(answer, cur+leaf);
        
        for(int child = 2; child<=3; child++){
            long nextSplit = split * child;
            if(nextSplit>splitLimit) continue;
            
            long newNode = cur * child;
            long remain = distLimit - used;
            long nextCur = Math.min(newNode, remain); 
            long nextLeaf = leaf + (newNode - nextCur);
            
            dfs(nextCur, used+nextCur, nextSplit, nextLeaf, distLimit, splitLimit);
            
            
        }
    }
}