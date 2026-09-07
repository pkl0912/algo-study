import java.util.*;
import java.lang.*;


class Solution {
    int max = 0;
    List<Integer>[] arr;
    int[] animal;
    
    public int solution(int[] info, int[][] edges) {
        animal = info;
        int n = info.length;
        arr = new ArrayList[n+1];
        for(int[] edge: edges){
            if(arr[edge[0]]==null){
                arr[edge[0]] = new ArrayList<>();
            }
            arr[edge[0]].add(edge[1]);
        }
        List<Integer> check = new ArrayList<>();
        check.add(0);
        
        dfs(0,0,0,check);
        return max;
        
    }
    public void dfs(int idx, int sheep, int wolf, List<Integer> checks){
        if(animal[idx]==0)sheep++;
        else wolf++;
        
        if(sheep<=wolf) return;
        
        max = Math.max(sheep, max);
        
        List<Integer> newChecks = new ArrayList<>(checks);
        newChecks.remove(Integer.valueOf(idx));
        
        
        if(arr[idx]!= null){
            newChecks.addAll(arr[idx]);
        }
        for(int next: newChecks){
            dfs(next, sheep, wolf, newChecks);
        }
        
    }
    
    
}