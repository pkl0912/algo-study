package programmers;

import java.util.*;

// todo : 다시
public class Solution43236 {

    class Solution {

        public int solution(int distance, int[] rocks, int n) {
            int answer = 0;

            int left = 0, right =  distance;
            Arrays.sort(rocks);

            // 거리를 temp -> 거래의 최솟값이 만족하는게 있는지 탐색 -> 최대거리를 변경
            while(left<=right){
                int mid = (int)((left+right)/2);
                int before = 0, smallCount = 0;

                for(int rock :rocks){
                    int diff = rock - before;
                    if(diff < mid){
                        smallCount +=1;
                    }else{
                        before = rock;
                    }
                }

                int diff = distance - before;
                if(diff < mid){
                    smallCount +=1;
                }

                if(smallCount > n){
                    right = mid-1;
                }else{
                    left=mid+1;
                    answer = mid;
                }

            }

            return answer;
        }
    }
}
