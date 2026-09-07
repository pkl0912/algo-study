package programmers.retry;
import java.util.*;
public class Solution42746_3 {

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            // string에서의 가장 큰 수.

            String[] nums = new String[numbers.length];
            for(int i=0; i<numbers.length; i++){
                nums[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(nums, (a,b) -> (b+b+b).compareTo(a+a+a) );

            if(Integer.valueOf(nums[0]) == 0){
                return "0";
            }

            return String.join("", nums);
        }
    }
}
