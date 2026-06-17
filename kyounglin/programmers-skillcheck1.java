package kyounglin;

import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int n = nums.length;
        return set.size()>n/2 ? n/2 : set.size();
    }
}
