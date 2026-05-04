package programmers;
import java.util.*;
public class Solution42890 {

    class Solution {

        int size;
        int cnt;
        ArrayList<Integer> combination;
        int answer;
        String[][] target;
        List<Set<Integer>> candidateKeys = new ArrayList<>();


        public int solution(String[][] relation) {
            answer = 0;
            size = relation[0].length;
            System.out.println(size);

            target = relation;

            // 백트래킹으로 경우의수를 조합하여 1개의 key, 2개의 key 등등을 조합하여 키를 만족하면 그 키는 제거
            // 1. 조합의 경우의 수를 구한다.
            for(int i=0; i<size; i++){
                cnt = i+1; // n개의 조합의 경우의 수를 구함
                combination = new ArrayList<>();
                dfs(0, 0); // 중복 x, 조합
            }





            return answer;
        }

        public void dfs(int depth, int start){
            // 2. 조합의 경우의 수를 돌면서 후보키인지 체크한다.
            if(cnt == depth){

                Set<Integer> set = new HashSet<>(combination);
                for (Set<Integer> key : candidateKeys) {
                    if (set.containsAll(key)) return;
                }

                // combination의 Index 조합으로 만드는 경우에 대해서 set을 구성. set의개수가 size와 동일한지 체크
                HashSet<String> data = new HashSet<>();

                for (int i = 0; i < target.length; i++) {
                    StringBuilder sb = new StringBuilder();

                    for (int col : combination) {
                        sb.append(target[i][col]).append(",");
                    }

                    data.add(sb.toString());
                }

                // data의 개수가 size와 동일한지 체크
                if (data.size() == target.length) {
                    answer++;
                    candidateKeys.add(set);
                }

                return;

            }

            for (int i = start; i < size; i++) {
                combination.add(i);
                dfs(depth + 1, i + 1);
                combination.remove(combination.size() - 1);
            }

        }
    }
}
