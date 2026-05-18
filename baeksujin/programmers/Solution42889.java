package programmers;
import java.util.*;
public class Solution42889 {
    class Solution {
        public int[] solution(int N, int[] stages) {


            // a -> currentStage와 동일한 것의 수 / b->  (currentStage보다 보다 크거나 같은 수)
            double[] failByStage = new double[N];
            for(int i=0; i<N; i++){
                int currentStage = i+1;

                int a=0;
                int b=0;
                for(int s : stages){
                    if(s==currentStage){
                        a++;
                    }
                    if(s >= currentStage){
                        b++;
                    }
                }

                System.out.println(a + "," + b);

                double fail = 0;

                if(a==0 && b==0){
                    fail = 0.0;
                }else{
                    fail = (double)a/b;
                }
                System.out.println(i + ": " + fail);

                failByStage[i] = fail;

            }


            System.out.println(Arrays.toString(failByStage));

            Integer[] index = new Integer[N];
            for(int i=0; i<N; i++){
                index[i] = i;
            };

            Arrays.sort(index, (i,j) -> {
                if(Double.compare(failByStage[i], failByStage[j]) ==0 ){// 동일할때 index우선
                    return Integer.compare(i,j);
                }

                return Double.compare(failByStage[j], failByStage[i]);
            });

            int answer[] = new int[N];
            for(int i=0; i<N; i++){
                answer[i] = index[i]+1;
            }

            return answer;
        }
    }
}
