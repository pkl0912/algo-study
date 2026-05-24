package programmers;

public class Solution43165 {

    class Solution {

        int cnt = 0;
        public int solution(int[] numbers, int target) {

            int current = numbers[0];
            dfs(numbers, target, current, 1);
            dfs(numbers, target, current*(-1), 1);
            return cnt;
        }

        public void dfs(int[] numbers, int target, int current, int depth){

            if(depth==numbers.length){

                if(current == target){
                    cnt+=1;
                }
                return;
            }


            dfs(numbers, target, current + numbers[depth], depth+1);
            dfs(numbers, target, current + numbers[depth]*(-1), depth+1);



        }




    }
}
