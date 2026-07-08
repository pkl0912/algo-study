package kyounglin;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();

        for (String s : info) {
            String[] arr = s.split(" ");
            int score = Integer.parseInt(arr[4]);

            for (int bit = 0; bit < 16; bit++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((bit & (1 << j)) != 0) {
                        key.append(arr[j]);
                    } else {
                        key.append("-");
                    }
                }
                String k = key.toString();
                map.computeIfAbsent(k, v -> new ArrayList<>()).add(score);
            }
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }


        for (int i = 0; i < query.length; i++) {
            String[] arr = query[i].split(" and ");
            String[] last = arr[3].split(" ");
            arr[3] = last[0];
            int score = Integer.parseInt(last[1]);

            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                key.append(arr[j].equals("-") ? "-" : arr[j]);
            }

            List<Integer> list = map.getOrDefault(key.toString(), new ArrayList<>());

            answer[i] = list.size() - lowerBound(list, score);
        }

        return answer;
    }

    private int lowerBound(List<Integer> list, int score) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < score) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}