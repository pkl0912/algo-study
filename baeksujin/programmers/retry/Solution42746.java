package programmers.retry;

import java.util.*;

public class Solution42746 {

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            int n = numbers.length;
            String[] str = new String[n];

            for(int i=0; i<n; i++){
                str[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(str, (a,b) -> (b+b+b).compareTo(a+a+a)); // 1000까지 커버
            // System.out.println(Arrays.toString(str));

            String result = String.join("", str);
            // 0인 경우
            if(result.charAt(0) == '0'){
                return "0";
            }

            return result;
        }
    }
}
