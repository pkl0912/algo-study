class Solution {
 	public int solution(int[] schedules, int[][] timelogs, int startday) {
        int peopleCount = schedules.length;
        int count = 0;

        for (int i=0; i<peopleCount; i++) {
            boolean success = true;

            int curday = startday;
            for (int j=0; j<7; j++) {
                if (1 <= curday && curday <= 5) {
                    int minute = toMin(timelogs[i][j]);
                    int limit = toMin(schedules[i]) + 10;

                    if (minute > limit) {
                        success = false;
                        break;
                    }
                }
                curday = (curday % 7) + 1;
            }
            if (success) count++;
        }

        int answer = count;
        return answer;
    }
    
    private int toMin(int hhmm) {
        int hour = hhmm / 100;
        int minute = hhmm % 100;
        return (hour * 60) + minute;
    }
}