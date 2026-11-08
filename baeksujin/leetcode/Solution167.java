package leetcode;

public class Solution167 {

    class Solution {
        /**
         시간복잡도 N
         공간복잡도 1 . 판단기준 : 개수가 아니라 N에 따라서 늘어나는가 -> 가 공간복잡도
         */
        public int[] twoSum(int[] numbers, int target) {

            /**
             문제이해.
             이미 정렬된 인덱스 배열 ( 오름차순 )

             두개를 더해서 target. find! => 1가지 정답이 존재 보장. 이 정답 index(1부터 시작)쌍을 구하는 문제

             s = l + r
             if(t > s) -> l ++
             if(t < s) -> r --
             if(t == s) -> 즉시 return


             l = 0; r = n-1;

             */

            // sorting ! 1,2,3,4,5 / 앞, 뒤에서 각각 1방향으로 찾아오면 N*2
            // for -> i , j -> 시간복잡도가 N^2.

            // 1. init
            int n = numbers.length;
            int l = 0, r = n-1;

            // 2. 포인터 탐색
            while(l < r){

                int sum = numbers[l] + numbers[r];

                if(target > sum){
                    l++;
                }
                if(target < sum){
                    r--;
                }
                if(target == sum){
                    return new int[]{l+1, r+1};
                }

            } // 123 (l==2,r==2) -> 두개를 더하면 안됨! 다를때만 반복문


            // 1개는 존재한다고 나와있으며 l==r일때는 못찾는 경우이기에 문제에서 고려대상이 아님.
            return new int[2];
        }
    }
}
