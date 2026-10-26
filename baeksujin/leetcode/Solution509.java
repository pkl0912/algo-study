package leetcode;

import java.util.Arrays;

public class Solution509 {

    class Solution {

        private int[] memo;

        public int fib(int n) {

            memo = new int[n+1];
            Arrays.fill(memo, -1);

            return getMemo(n);


        }

        private int getMemo(int n){

            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }

            if(memo[n] != -1){
                return memo[n];
            }
            memo[n] = getMemo(n-1) + getMemo(n-2);

            return memo[n];


        }



    }
}
