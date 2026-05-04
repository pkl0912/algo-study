package programmers;
import java.util.*;
public class Solution137101 {

    class Solution {
        public int solution(int[] elements) {

            int n = elements.length;

            // 배열 늘리기 1번만 붙이면 됨
            int[] arr = new int[n * 2];
            for (int i = 0; i < n * 2; i++) {
                arr[i] = elements[i % n];
            }

            Set<Integer> set = new HashSet<>();
            for (int len = 1; len <= n; len++) {

                for (int start = 0; start < n; start++) {

                    int sum = 0;

                    for (int k = 0; k < len; k++) {
                        sum += arr[start + k];
                    }

                    set.add(sum);
                }
            }

            return set.size();
        }
    }
}
