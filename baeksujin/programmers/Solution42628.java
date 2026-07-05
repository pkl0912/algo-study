package programmers;
import java.util.*;
public class Solution42628 {

    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {};

            PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();

            for(int i=0; i<operations.length; i++){
                String o = operations[i];
                String[] os = o.split(" ");
                String oper = os[0], value = os[1];

                if(oper.equals("I")){
                    // insert
                    maxQueue.offer(Integer.parseInt(value));
                    minQueue.offer(Integer.parseInt(value));
                }else{
                    if(maxQueue.size() == 0){
                        continue;
                    }
                    if(value.equals("1")){
                        // 최댓값 삭제
                        Integer max = maxQueue.poll();
                        minQueue.remove(max);
                    }else{
                        //최솟값 삭제
                        Integer min = minQueue.poll();
                        maxQueue.remove(min);
                    }

                }



            }

            if(minQueue.size() > 0 || maxQueue.size() >0){
                return new int[]{maxQueue.poll(),minQueue.poll()};
            }

            return new int[]{0,0};
        }
    }
}
