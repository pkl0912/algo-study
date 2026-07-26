package kyounglin;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.add(queue1[i]);
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }


        if ((sum1 + sum2) % 2 != 0) return -1;

        long target = (sum1 + sum2) / 2;
        int cnt = 0;
        int maxCnt = queue1.length * 3; 

        while (sum1 != target && cnt <= maxCnt) {
            if (sum1 > target) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }
            cnt++;
        }

        return sum1 == target ? cnt : -1;
    }
}