package kyounglin;
import java.util.*;

class Solution {
    public List<String> arr = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        List<String> selected = new ArrayList<>();
        selected.add("ICN");
        dfs("ICN", 0, tickets, new boolean[tickets.length], selected);
        
        return arr.stream().toArray(String[]::new);
    }
    public void dfs(String start, int cnt, String[][] tickets, boolean[] visited, List<String> selected){
        if(cnt==visited.length){
            if(compareList(selected)){
                arr = new ArrayList<>(selected);
            }
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            String[] ticket = tickets[i];
            if(ticket[0].equals(start) && !visited[i]){
                visited[i] =true;
                selected.add(ticket[1]);
                dfs(ticket[1], cnt+1, tickets, visited, selected);
                selected.remove(selected.size()-1);
                visited[i] = false;
            }
        }
        
    }
    public boolean compareList(List<String> selected){
        if(arr.size()==0) return true;
        
        for(int i = 0; i<selected.size(); i++){
            if(selected.get(i).compareTo(arr.get(i))>0) return false;
            if(selected.get(i).compareTo(arr.get(i))<0) return true;
        }
        return false;
    }

}