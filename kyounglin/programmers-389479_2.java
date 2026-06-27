package kyounglin;

import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;
        int cur = 0;
        
        for(int i = 0; i<players.length; i++){
            while(!q.isEmpty() && q.peek()[0]<= i){
                cur-=q.poll()[1];
            }
            int need = players[i] / m - cur;
            if(need>0){
                answer+= need;
                cur+= need;
                q.add(new int[]{i+k,need});
            }
        }
        return answer;
    }
}
