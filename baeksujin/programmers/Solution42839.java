package programmers;

import java.util.*;

public class Solution42839 {

    class Solution {

        Set<Integer> set = new HashSet<>();
        boolean[] visited;

        public boolean isPrime(int value){

            if(value==1 || value == 0){
                return false;
            }
            for(int i=2; i<(int)(Math.sqrt(value))+1; i++){
                if(value % i ==0){
                    return false;
                }
            }
            return true;


        }


        public void permutation(int depth, int limit, char[] nums, String current){

            if(depth == limit){
                set.add(Integer.valueOf(current));
                return;
            }

            for(int i=0; i<nums.length; i++){
                if(visited[i]) continue;

                visited[i] = true;
                permutation(depth+1, limit, nums, current + nums[i]);
                visited[i] = false;
            }



        }



        public int solution(String numbers) {
            int answer = 0;


            char[] nums = numbers.toCharArray();
            //System.out.println(Arrays.toString(nums));

            int maxLen = nums.length;
            //System.out.println(Arrays.toString(nums));
            for(int i=1; i<=maxLen; i++){

                int depth = 0, limit = i;
                visited = new boolean[maxLen];
                permutation(0, limit, nums, "");


            }

            for(int num : set){
                if(isPrime(num)){
                    answer++;
                }
            }
            return answer;
        }
    }
}
