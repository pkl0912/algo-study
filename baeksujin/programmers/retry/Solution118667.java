package programmers.retry;

public class Solution118667 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int answer = -2;

            int sum1 =0, sum2 =0;

            for(int q : queue1){
                sum1 += q;
            }
            for(int q: queue2){
                sum2 += q;
            }

            int sum = sum1 + sum2;
            if(sum%2 != 0 ) return -1;
            long same = sum / 2;


            // queue1의 합을 same으로 만들기 위한 최소횟수(이동횟수는 맥시멈으로 기리*3)

            int n = queue1.length;
            int limit = n *3;

            int[] array = new int[n*2];
            for(int i=0; i<n; i++){
                array[i] = queue1[i];
                array[i+n] = queue2[i];
            }

            int left = 0, right = n-1;

            int count = 0;

            while(count <= limit){

                if(same == sum1){
                    return count;
                }

                if(sum1 < same){ // sum1을 키워야하니 right+
                    right++;
                    if(right >= array.length) return -1;
                    sum1 += array[right];
                }else{
                    sum1 -= array[left];
                    left++;
                }

                count+=1;

            }


            return -1;
        }
    }

}
