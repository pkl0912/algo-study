import java.util.*;
class Solution {
    public int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers.length, target, numbers);
        return answer;
    }
    public void dfs(int cnt, int num, int n, int target, int[] numbers){
        if(cnt==n){
            if(num==target) answer++;
            return;
        }
        dfs(cnt+1, num-numbers[cnt], n, target, numbers);
        dfs(cnt+1, num+numbers[cnt], n, target, numbers);
    }
    
}