package kyounglin;

package kyounglin;
import java.util.*;

class Solution {
    public PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
        if(a[0]==b[0]) return b[1]-a[1];
        return b[0] - a[0];
    });
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, users, emoticons, new ArrayList<>());
        int[] answer = new int[2];
        if(!pq.isEmpty()){
            answer = pq.poll();
        }
        return answer;
    }
    public void dfs(int cnt, int[][]users, int[] emoticons, List<Integer>selected){
        if(cnt==emoticons.length){
            int sell = 0;
            int plus = 0;
            for(int j = 0; j<users.length; j++){
                int[] user = users[j];
                int buy = 0;
                
                for(int i = 0; i<cnt; i++){
                    int discount = selected.get(i);
                    int price = emoticons[i] * (100-discount)/100;
                    if(user[0]<=discount){
                        buy+=price;
                    }
                }
                if(buy>=user[1]){
                    plus++;
                }else{
                    sell+=buy;
                }
            }
            pq.add(new int[]{plus, sell});
            return;
        }
        
        for(int i = 10; i<=40; i+=10){
            selected.add(i);
            dfs(cnt+1, users, emoticons, selected);
            selected.remove(selected.size()-1);
        }
    }
    
}