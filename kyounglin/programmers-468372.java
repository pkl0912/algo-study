import java.util.*;

class Solution {
    int answer = 1;

    public int solution(int dist_limit, int split_limit) {
        dfs(1, 1, 1, 0, dist_limit, split_limit);
        return answer;
    }
    public void dfs(long cur, long used, long split, long leaf, int dist_limit, int split_limit){
        if(used>dist_limit) return;
        
        answer = (int)Math.max(answer, cur+leaf);
        
        for(long child = 2; child<=3; child++){
            long nextSplit = split * child;
            if(nextSplit>split_limit) continue;
            
            long newNode = cur * child;
            long nextCur = Math.min(newNode, dist_limit-used);
            long nextLeaf = leaf+(newNode-nextCur);
            
            dfs(nextCur, used+nextCur, nextSplit, nextLeaf, dist_limit, split_limit);
        }
    
    }

}