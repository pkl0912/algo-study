package programmers;

public class Solution12924 {

    class Solution {
        public int solution(int n) {
            int answer = 0;

            // 부분합이 n이 되는 경우의수를 구하는 문제

            int[] array = new int[10001];

            for(int i=1; i<array.length; i++){
                array[i] = i;
            }

            int left = 0, right = 0, sum=0;
            int count= 0;
            while(left <= right){

                if(sum == n){
                    count+=1;
                }

                if(sum <= n){
                    // sum은 더 필요함
                    right++;
                    if(right >= 10001) return count;
                    sum += array[right];
                }else{
                    sum -= array[left];
                    left ++;
                }


            }



            return count;
        }
    }
}
