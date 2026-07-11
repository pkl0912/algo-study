package programmers;

public class Solution340212 {

    class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            int answer = 0;

            // 최소 숙련련도 -> 숙련도(level) : 이분탐색 대상
            int maxD = 0;
            for(int d : diffs){
                maxD  = d > maxD ? d : maxD;
            }
            int start = 1, end = maxD;


            while(start <= end){

                int level = (start + end) / 2;



                long currentSolveTime = 0;
                for(int i=0; i<diffs.length; i++){
                    int problemLevel = diffs[i];
                    int problemSolveTime = times[i];
                    if(problemLevel <= level){
                        currentSolveTime += problemSolveTime;
                    }else{
                        int n = problemLevel - level;
                        currentSolveTime += n * (times[i-1] + problemSolveTime) + problemSolveTime;
                    }

                }

                // currentLevel을 가지고 제한시간안에 풀수있다면 currentLevel을 낮춰도 됨(동시에 후보가능).
                if(currentSolveTime <= limit){
                    end = level-1;
                    answer = level;
                }else{
                    start = level+1;
                    // currentLevel을 까지고 제한시간안에 풀수없다면 currentLevel을 높여야함.
                }


            }

            return answer;
        }
    }
}
