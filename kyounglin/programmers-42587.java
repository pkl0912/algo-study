package kyounglin;

import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = priorities.length;
        int answer = 0;
        for(int i = 0; i<n; i++){
            q.add(new int[]{priorities[i], i});
        }
        Arrays.sort(priorities);
        for(int i = n-1; i>=0; i--){
            q2.add(priorities[i]);
        }
        int cnt = 0;
        while(!q2.isEmpty()){
            int num = q2.poll();
            cnt++;
            while(!q.isEmpty() && q.peek()[0]<num){
                int[] cur = q.poll();
                q.add(cur);
            }
            if(!q.isEmpty() && q.peek()[0]>=num){
                int[] cur = q.poll();
                if(cur[1]==location){
                    answer = cnt;
                    return answer;
                }
            }
        }
        return answer;
    }
}