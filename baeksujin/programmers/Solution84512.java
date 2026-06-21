package programmers;

import java.util.*;

public class Solution84512 {

    class Solution {

        Set<String> set = new HashSet<>();

        public void permutation(int depth, int limit, String current, String[] list){

            if(depth == limit){
                // current를 저장
                set.add(current);
                return;
            }

            // 순회 중복허용
            for(int i=0; i<list.length; i++){
                permutation(depth+1, limit, current + list[i], list);
            }


        }
        public int solution(String word) {
            int answer = 0;


            // a,e,i,o,u를 가지고 만들 수 있는 중복가능한 모든 경우의 수(len 1~5)
            String[] alpha = {"A","E","I","O","U"};
            System.out.println(Arrays.toString(alpha));

            for(int i=0; i<5; i++){

                int len = i+1;
                permutation(0, len, "", alpha);

            }


            // sort -> list
            List<String> values = new ArrayList<>(set);
            values.sort((a,b) -> a.compareTo(b));
            // list -> findIndex

            return values.indexOf(word)+1;
        }
    }
}
