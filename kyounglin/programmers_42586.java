import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            int remain = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i])%speeds[i] != 0) remain++;
            q.add(remain);
        }
        List<Integer> arr = new ArrayList<>();
        int max = q.peek();
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur>max){
                max = cur;
                arr.add(cnt);
                cnt = 1;
            }else{
                cnt++;
            }
        }
        arr.add(cnt);
        int[] answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}