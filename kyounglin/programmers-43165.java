package kyounglin;

import java.util.*;
class Solution {
    public int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, new ArrayList<>());
        return answer;
    }
    public void dfs(int cnt, int[]numbers, int target, List<Integer> selected ){
        if(cnt==numbers.length){
            int num = 0;
            if(selected.get(0)==0) num = numbers[0];
            else if(selected.get(0)==1) num = (-1)* numbers[0];
            for(int i = 1; i<cnt; i++){
                int op = selected.get(i);
                if(op==0) num+=numbers[i];
                else if(op==1) num-=numbers[i];
            }
            if(num==target) answer++;
            return;
        }
    
        for(int i = 0; i<2; i++){
            selected.add(i);
            dfs(cnt+1, numbers, target, selected);
            selected.remove(selected.size()-1);
        }
    }
}