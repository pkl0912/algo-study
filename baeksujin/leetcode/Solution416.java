package leetcode;

public class Solution416 {

    class Solution {
        public boolean canPartition(int[] nums) {

            // 선택하는 경우와 미선택하는 경우 존재. -> 조합해서 sum/2가 가능한지 확인
            int sum=0;
            for(int n : nums){
                sum += n;
            }

            boolean[] dp = new boolean[sum+1];
            if(sum%2==1){
                return false;
            }
            int target = (sum)/2;

            // 0을 만들 수 있는 조합 -> true / 아무것도안고르는 경우 합 0
            dp[0] = true;

            for(int i=0; i<nums.length; i++){
                int num = nums[i];
                for(int j=target; j>=num; j--){
                    dp[j] = dp[j] || dp[j- num]; // current만 사용 or 이전값 활용
                } // 이전값 재사용을 못해서 역방향 순회필요
            }

            return dp[target];


        }
    }
}
