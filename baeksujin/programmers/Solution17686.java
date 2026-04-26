package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution17686 {
    public String[] solution(String[] files) {

        List<String[]> list = new ArrayList<>();
        // [head, number, index, original]

        // 1. head
        // 대소문자 비교를 하지 않기 위해 전부 소문자로 변경
        // 소문자로 변경
        // 2. number
        // 0을 제외하여 숫자로 만든뒤 정렬필요 작을수록 우선순위
        // 3. 입력시 들어온 순서가 우선순위


        for (int i = 0; i < files.length; i++) {
            String file = files[i];

            int idx = 0;

            // 1. HEAD
            while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
                idx++;
            }
            String head = file.substring(0, idx);

            // 2. NUMBER
            int start = idx;
            while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
                idx++;
            }
            String number = file.substring(start, idx);

            list.add(new String[]{
                    head.toLowerCase(),  // 정렬용
                    number,              // 정렬용
                    String.valueOf(i),   // 입력 순서
                    file                 // 원본
            });
        }

        // 정렬
        list.sort((a, b) -> {
            // 1. HEAD 오름차순
            int cmp = a[0].compareTo(b[0]);
            if (cmp != 0) return cmp; // 동일할 때에 대해서만 뒤의 정렬조건 실행

            // 2. NUMBER 오름차순
            cmp = Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            if (cmp != 0) return cmp;

            // 3. INDEX 오름차순
            return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
        });

        // 결과 생성
        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i)[3];
        }

        return answer;
    }

}
