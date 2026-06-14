package programmers;
import java.util.*;
public class Solution42895 {



    class Solution {
        public int solution(int N, int number) {
            int answer = -1;

            // result를 만들 수 있는 경우의 수 -> 다음 경우의 수에 영향을 줌


            List<Set<Integer>> dp = new ArrayList<>(); // i개의 N으로 만들 수 있는 경우의 수의 집합

            // 8개까지만 N 사용을 허용함
            for(int i=0; i<=8; i++){
                dp.add(new HashSet<>());
            }

            for(int i=1; i<=8; i++){

                int num = 0;
                //n을i개를 가지고 만들 수 있는 경우
                for(int j=0; j<i; j++){
                    num  = num *10+N;
                }

                dp.get(i).add(num);

                // 이전 조합을 사용해서 (If n -> 4 : 1+3/2+2의 조합) 결과를 사칙연산하여 조합
                for(int j=1; j<i; j++){

                    for(int a : dp.get(j)){
                        for(int b : dp.get(i-j)){

                            dp.get(i).add(a+b);
                            dp.get(i).add(a-b);
                            dp.get(i).add(a* b);
                            if(b!=0) dp.get(i).add(a/b);


                        }
                    }


                }


                if(dp.get(i).contains(number)){
                    return i;
                }



            }




            return answer;
        }
    }
}
