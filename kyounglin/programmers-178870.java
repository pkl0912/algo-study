package kyounglin;

import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        int lt = 0;
        int rt = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;
        while(rt<n){
            if(sum<k){
                rt++;
                if(rt<n) sum+=sequence[rt];
            }else if(sum>k){
                
                if (lt < rt) {
                    sum -= sequence[lt];
                    lt++;
                } else {
                    rt++;
                    if (rt < n) sum += sequence[rt];
                }
            }else if(sum==k){
                if(min>rt-lt){
                    min = rt-lt;
                    answer[0] = lt;
                    answer[1] = rt;
                }
                sum -= sequence[lt];
                lt++;
                
            }
        }
        return answer;
    }
}