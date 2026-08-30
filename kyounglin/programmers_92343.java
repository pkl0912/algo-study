import java.util.*;
import java.lang.*;


class Solution {
    static int max = 0;
    static int[] animal;
    static ArrayList<Integer>[] childs;
    
    public int solution(int[] info, int[][] edges) {
        animal = info;
        childs = new ArrayList[info.length]; 
        for(int[] edge : edges) {
            if(childs[edge[0]] == null) {
                childs[edge[0]] = new ArrayList<>();
            }    
            childs[edge[0]].add(edge[1]);
        }
        
        List<Integer> check = new ArrayList<>();
        check.add(0);
        
        dfs(0,0,0, check);
        return max;
        
    }
    
    public void dfs(int idx, int sheep, int wolf, List<Integer> checks){
        if(animal[idx]==0) sheep++;
        else wolf++;
        
        if(sheep<=wolf) return;
        
        max = Math.max(sheep, max);
        
        List<Integer> newChecks = new ArrayList<>(checks);
        newChecks.remove(Integer.valueOf(idx));
        
        if(childs[idx]!=null){
            newChecks.addAll(childs[idx]);
        }
        for(int next:newChecks){
            dfs(next, sheep, wolf, newChecks);
        }
    }
    
}