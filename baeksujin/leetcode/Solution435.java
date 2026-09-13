package leetcode;


import java.util.Arrays;

public class Solution435 {

    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {

            // non overlapping을 만들려고할때 지워야하는 interval의 최소갯수

            // e 좌표순서로 오름차순정렬

            Arrays.sort(intervals, (a, b) -> {
                return a[1] - b[1];
            });


            int currentS = intervals[0][0];
            int currentE = intervals[0][1];
            int removeCount = 0;


            for(int i=1; i<intervals.length; i++){

                int nextS = intervals[i][0];
                int nextE = intervals[i][1];

                if(nextS < currentE){ // 구간이겹치는 경우
                    removeCount+=1;
                    continue;
                }

                // 구간이 겹치지 않음
                currentS = nextS;
                currentE = nextE;

            }


            return removeCount;


        }
    }
}
