package leetcode;

public class Solution35 {

    class Solution {
        public int searchInsert(int[] nums, int target) {

            // 이분탐색 진행
            // 정렬은 기존에 되어있음
            // 10^8 logN

            int s = 0, e = nums.length;// 가장 마지막에 추가될수있음을 고려
            while(s<e){

                int m = (s+e)/2;

                if(nums[m] < target){ // target이 더 크기때문에 m이후로 탐색
                    s = m+1;
                }else{ // target이 작거나 같기 때문에 m까지 탐색
                    e = m;
                }

            }

            return s;
        }
    }
}
