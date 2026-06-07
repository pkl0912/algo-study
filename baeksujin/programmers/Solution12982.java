package programmers;
import java.util.*;

public class Solution12982 {


    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;

            // budget을 만족하는 부서수를 고르고, 최대 부서수를 찾아야함.

            int count = d.length;
            int start =0, end = count-1;

            // 정렬
            Arrays.sort(d);
            int[] sumD = new int[count];
            sumD[0] = d[0]; // i번째까지의 합 -> sum[i]
            for(int i=1; i < count; i++){
                sumD[i] = sumD[i-1] + d[i];
            }


            while(start <= end){

                int mid = (start+end)/2;
                // mid개의 부서수를 합쳤을 때 d보다 작거나 같은지 확인해야한다.
                if(sumD[mid] <= budget ){
                    // 가능한 부서수이기에 기록하고 부서수를 늘려본다.
                    answer = mid+1;
                    start = mid+1;

                }else{
                    // 불가능한 부서수이기에 기록하지 않고, 부서수를 줄인다.
                    end = mid-1;
                }

            }


            return answer;
        }
    }
}
