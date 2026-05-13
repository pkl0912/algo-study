package programmers;
import java.util.*;
public class Solution42746 {

    public String solution(int[] numbers) {
        String answer = "";

        // 이은값이 더 큰것을 우선순위로 하여 정렬
        String[] nums = new String[numbers.length];
        for(int i=0; i< numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (a,b) -> {
            return (b+a).compareTo(a+b); // 오름차순 정렬
        });

        if(nums[0].equals("0")) return "0";


        answer = "".join("", nums);


        return answer;
    }
}
