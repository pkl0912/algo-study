package kyounglin;

import java.util.*;
class Solution {
    public int answer;
    public int solution(int n, int[][] q, int[] ans) {
        dfs(1, n, q, ans, new ArrayList<>());
        return answer;
    }
    public void dfs(int start, int n, int[][]q, int[] ans, List<Integer> selected){
        if(selected.size()==5){
            boolean isAnswer = true;
            for(int i = 0; i<q.length; i++){
                int cnt = 0;
                int[] arr = q[i];
                
                for(int num: selected){
                    for(int a: arr){
                        if(a==num) cnt++;
                    }
                }
                if(cnt!=ans[i]){
                    isAnswer = false;
                    break;
                }
            }
            
            if(isAnswer){
                answer++;
            }
            return;
        }
        for(int i = start; i<=n; i++){
            if(!selected.contains(i)){
                selected.add(i);
                dfs(i+1, n, q, ans, selected);
                selected.remove(selected.size()-1);
            }
            
        }
    }
}