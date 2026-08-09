package kyounglin;

import java.util.*;

class Solution {
    Map<Integer, List<Integer>> possibleWordMap = new HashMap<>();
    Set<Set<Integer>> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {
            List<Integer> candidates = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                if (canMarked(user_id[j], banned_id[i])) {
                    candidates.add(j);
                }
            }
            possibleWordMap.put(i, candidates);
        }

        boolean[] visited = new boolean[user_id.length];
        dfs(0, banned_id.length, visited, new ArrayList<>());

        return resultSet.size();
    }

    public void dfs(int idx, int n, boolean[] visited, List<Integer> selected) {
        if(idx==n){
            resultSet.add(new HashSet<>(selected));
            return;
        }

       for(int userIdx: possibleWordMap.getOrDefault(idx, new ArrayList<>())){
           if(!visited[userIdx]){
               visited[userIdx] = true;
               selected.add(userIdx);
               dfs(idx+1, n, visited, selected);
               selected.remove(selected.size()-1);
               visited[userIdx] = false;
            }
       }
    }

    public boolean canMarked(String id, String ban) {
        if (id.length() != ban.length()) return false;

        for (int i = 0; i < id.length(); i++) {
            if (ban.charAt(i) == '*') {
                continue;
            } else {
                if (id.charAt(i) != ban.charAt(i)) return false;
            }
        }
        return true;
    }
}