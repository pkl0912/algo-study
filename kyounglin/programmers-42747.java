package kyounglin;

import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int n = citations.length;
        for(int h = 0; h<=citations[n-1]; h++){
            int big = 0;
            int small = 0;
            for(int c: citations){
                if(c>=h) big++;
                if(c<=h) small++;
            }
            if(big>=h && small<=h) answer = h; 
        }
        return answer;
    }
}