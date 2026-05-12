package programmers;
import java.util.*;

public class Solution42587 {


    class Solution {
        public int solution(int[] priorities, int location) {
            int index = 0;
            int answer[] = new int[priorities.length];

            // 값을 사용해서 비교해야하고 Location을 Key로 사용하면서 끄집어내면서 location과 위치를 비교

            Deque<int[]> values = new ArrayDeque<>();
            for(int i=0; i<priorities.length; i++){
                values.offer(new int[]{i, priorities[i]});
            }

            while(!values.isEmpty()){

                int[] current = values.pollFirst();
                int currentValue = current[1];

                boolean goTail = false;
                for(int[] next : values){
                    int nextValue = next[1];
                    if(nextValue > currentValue){
                        goTail = true;
                        break;
                    }
                }


                if(goTail){
                    values.offer(current);
                }else{
                    answer[index] = current[0];
                    index+=1;
                }

            }

            //System.out.println(Arrays.toString(answer));

            for(int i=0; i<answer.length; i++){
                if(answer[i]==location){
                    return i+1;
                }
            }

            return -1;
        }
    }
}
