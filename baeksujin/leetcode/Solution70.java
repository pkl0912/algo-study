package leetcode;

public class Solution70 {

    class Solution {

        private int[] step;

        public int climbStairs(int n) {

            step = new int[n+1];

            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }
            if(n==2){
                return 2;
            }

            step[0] = 0; step[1] = 1; step[2] = 2;
            for(int i=3; i<=n; i++){
                step[i] = step[i-1] + step[i-2];
            }

            return step[n];

            // Arrays.fill(step, -1);
            // return getStep(n);
        }

        private int getStep(int n){

            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }
            if(n==2){
                return 2;
            }

            if(step[n] != -1){
                return step[n];
            }

            step[n] =  getStep(n-1) + getStep(n-2);
            return step[n];
        }
    }
}
