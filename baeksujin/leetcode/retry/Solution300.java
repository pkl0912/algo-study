package leetcode.retry;

import java.util.Arrays;

public class Solution300 {

    // 19:05 시작~ 19:16 끝 ( 1차 )
// 10:30 재시작~ 10:49

    /**
     nLogN 이분탐색 구현
     */

    class Solution {

        int[] tails;

        void debug(int[] arrays){

            System.out.println(Arrays.toString(arrays));

        }

        int bst(int[] tails, int current){

            // left, right, mid
            int l = 0;
            int r = tails.length;
            // 1,2,3 -> n/2 -> 1 : num 2 // 1,2,3,4 -> 3까지 탐색

            int index = 0;
            while(l < r){

                int mid = (l+r)/2;

                // mid >= target -> 정답가능
                if(tails[mid] >= current){// 들어있는 값보다 크거나 같은 첫 위치
                    r = mid;
                }

                // mid < target(같을 때까지 후보가능) -> mid를 높여야함
                else{
                    l = mid+1;
                }
            }

            return l;// or r

        }


        public int lengthOfLIS(int[] nums) {


            // 이분탐색으로 변경가능

            // tail index : 길이
            // 10 -> tails[1] = 10;
            // 9 -> tails[1] = 9; // num change
            // 2-> tails[1] = 2; // left bst(tails)
            // 5 -> tails[2] = 5; // right -> +1 tails
            // 3-> tails[2]; // 2<3<5 -> 5(index2) -> 2
            // 7 -> tails[3]; // 2<3<7 -> right -> +1 tails
            // 101 -> tails[4];
            // 18 -> 7<18<101 -> index 4

            // init
            int n = nums.length;
            tails = new int[n];
            Arrays.fill(tails, 10001);


            // index 탐색
            int result = 1;
            for(int i=0; i<n; i++){ //n
                int current = nums[i];
                int idx = bst(tails, current);//log(N)

                tails[idx] = current;
                result = Math.max(idx+1, result);// length = index+1

            }// nLogN

            return result;


        }


        public int lengthOfLIS1(int[] nums) {

            // 가장 긴 증가하는 부분수열

            // 앞의 값(누적 증가하는 부분 수열의 개수)보다 현재값이 클 때 => Math.max(current+1, dp[current])

            // init
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1); // 시간복잡도 : N

            // 앞의 누적결과를 바탕으로 현재값을 update
            for(int i=1; i<n; i++){ // N

                // before < currrent -> +1 ( 이중에서 max )
                for(int j=0; j<i; j++){ // 시간복잡도 : N (앞의 원소를 싹 보니까 N)
                    int before = nums[j];
                    int current = nums[i];

                    if(before < current){
                        dp[i] = Math.max(dp[j]+1, dp[i]); //공간복잡도 dp : N
                    }


                }

            } // NlogN

            // get result
            int max = 0;
            for(int i=0; i<n; i++){
                max = Math.max(max, dp[i]);
            }

            return max;



        }
    }
}
