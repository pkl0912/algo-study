package kyounglin;

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String numString = Integer.toString(n, k);
        String[] nums = numString.split("0");
        for(String num: nums){
            if(!num.isEmpty() && isPrime(Long.parseLong(num))){
                answer++;
            }
        }
        return answer;
    }
    public boolean isPrime(long number){
        if(number<2) return false;
        if(number==2 || number==3) return true;
        for(long i = 2; i*i<=number; i++){
            if(number%i==0) return false;
        }
        return true;
    }
}