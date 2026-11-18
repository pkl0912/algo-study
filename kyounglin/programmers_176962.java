
import java.util.*;

class Solution {

    public String[] solution(String[][] plans) {

        int n = plans.length;

        for (int i = 0; i < n; i++) {
            String[] time = plans[i][1].split(":");

            int start = Integer.parseInt(time[0]) * 60
                      + Integer.parseInt(time[1]);

            plans[i][1] = String.valueOf(start);
        }

        Arrays.sort(plans, (a, b) ->
            Integer.parseInt(a[1]) - Integer.parseInt(b[1])
        );

        Stack<String[]> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {

            String name = plans[i][0];
            int start = Integer.parseInt(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);

            int nextStart = Integer.parseInt(plans[i + 1][1]);

            int available = nextStart - start;

            if (playtime > available) {
                playtime -= available;
                stack.push(new String[]{name, String.valueOf(playtime)});

            } else {
                result.add(name);

                int remain = available - playtime;

                while (remain > 0 && !stack.isEmpty()) {

                    String[] paused = stack.pop();

                    int pausedTime = Integer.parseInt(paused[1]);

                    if (pausedTime <= remain) {

                        result.add(paused[0]);
                        remain -= pausedTime;

                    } else {

                        pausedTime -= remain;
                        stack.push(new String[]{
                            paused[0],
                            String.valueOf(pausedTime)
                        });
                        remain = 0;
                    }
                }
            }
        }

        result.add(plans[n - 1][0]);

        while (!stack.isEmpty()) {
            result.add(stack.pop()[0]);
        }

        return result.toArray(new String[0]);
    }
}