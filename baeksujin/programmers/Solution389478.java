package programmers;

public class Solution389478 {

    class Solution {
        public int solution(int n, int w, int num) {
            int answer = 0;
            // 각 줄은 w개 포함가능. 몫을 사용하여 몇번째 줄에있는지 구하고 차이를 계산.

            // max 1 + 22/6 -> 1+3 -> 4층
            int top = (n%w) == 0 ? (n/w) : 1 + (n / w );
            //System.out.println(top);
            int numLevel = ((num%w) == 0) ? (num/w) : 1 + (num / w);
            //System.out.println(numLevel);
            // 다만, 마지막줄의 같은 위치에 상자가 없다면 -1
            int topCount = n - ((top-1) * w );
            //System.out.println(topCount);
            boolean isEven = top % 2 == 0 ? true : false;
            //System.out.println(isEven);

            int numCount = num - ((numLevel-1) * w);
            //System.out.println(numCount);
            boolean isEvenNum = numLevel % 2 == 0 ? true:false;
            //System.out.println(isEvenNum);

            if(isEven == isEvenNum){ // 같은 배수

                if(topCount >= numCount){
                    answer = top - numLevel + 1;
                }else{
                    answer =  top - numLevel - 1 + 1;
                }

            }else{ // 다른 배수의 층에 존재할때

                if(topCount + numCount > w){
                    answer = top - numLevel + 1;
                }else{
                    answer = top-numLevel-1 + 1;
                }

            }

            if(answer <= 0 ){
                answer = 0;
            }
            return answer;
        }
    }
}
