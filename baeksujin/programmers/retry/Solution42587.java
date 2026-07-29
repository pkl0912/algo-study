package programmers.retry;

import java.util.*;

public class Solution42587 {

    class Solution {
        public int solution(int[] priorities, int location) {

            List<Integer> node = new ArrayList<>();

            Deque<int[]> deque = new ArrayDeque<>();

            for(int i=0; i<priorities.length; i++){
                deque.offer(new int[]{i, priorities[i]});
            }


            while(!deque.isEmpty()){

                int[] current = deque.poll();

                int i = current[0];
                int priority = current[1];

                boolean isTop = true;


                // 뒤에 더 높은 우선순위가 있는지 확인
                for(int[] next : deque){

                    if(next[1] > priority){

                        isTop = false;
                        break;
                    }
                }


                if(!isTop){

                    deque.offer(current);

                }else{

                    node.add(i);

                }
            }


            return node.indexOf(location)+1;
        }
    }
}
