package kyounglin;

import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int max = 1;
        int answer = 0;
        for(int[] signal: signals){
            int sum = signal[0]+signal[1]+signal[2];
            max*= sum;
        }
        for(int i = 3; i<=max; i++){
            boolean isAll = true;
            for(int[] signal: signals){
                int sum = signal[0]+signal[1]+signal[2];
                int mod = i%sum;
                if(mod<=signal[0] || mod>signal[0]+signal[1]){
                    isAll = false;
                    break;
                }
            }
            if(isAll){
                answer = i;
                break;
            }
        }
        return answer==0?-1:answer;
    }
}
