package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution17677 {
    class Solution {

        final int BASIC_NUM = 65536;

        // isLetter로 문자체크 필요.
        private void makeList(String str, List<String> list) {
            for (int i = 0; i < str.length() - 1; i++) {
                char c1 = str.charAt(i);
                char c2 = str.charAt(i + 1);

                if (Character.isLetter(c1) && Character.isLetter(c2)) {
                    list.add("" + c1 + c2);
                }
            }
        }

        public int solution(String str1, String str2) {
            int answer = 0;

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            // 1. 다중집합 생성
            makeList(str1, list1);
            makeList(str2, list2);

            // 2. 교집합 계산
            int intersection = 0;

            List<String> temp = new ArrayList<>(list2); // deepCopy

            for (String s : list1) {
                if (temp.contains(s)) {
                    intersection++;
                    temp.remove(s); // 하나만 제거 → 다중집합 처리 핵심
                }
            }

            // 3. 합집합
            int union = list1.size() + list2.size() - intersection;

            // 4. 공집합 처리
            if (union == 0) return BASIC_NUM;

            // 5.유사도
            return (int) ((double) intersection / union * BASIC_NUM);

        }
    }
}
