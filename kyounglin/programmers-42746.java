package kyounglin;

import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            strs[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strs, (a,b)-> (b+a).compareTo(a+b));
        if(strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<strs.length; i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}