import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> countMap = new TreeMap<>(Collections.reverseOrder());
        Map<String, List<int[]>> sortMap = new HashMap<>();
        
        int n = genres.length;
        
        for(int i = 0; i<n; i++){
            String genre = genres[i];
            map.put(genre, map.getOrDefault(genre, 0)+plays[i]);
            
            sortMap.putIfAbsent(genre, new ArrayList<>());
            sortMap.get(genre).add(new int[]{plays[i], i});
        }
        for(String key: map.keySet()){
            countMap.put(map.get(key), key);
        }
        
        for(String key: sortMap.keySet()){
            List<int[]> arr = sortMap.get(key);
            arr.sort((a, b)->{
                if(a[0]!=b[0]) return Integer.compare(b[0], a[0]);
                return Integer.compare(a[1], b[1]);
            });
        }
        List<Integer> answerList = new ArrayList<>();
        
        for(Integer cnt: countMap.keySet()){
            String genre = countMap.get(cnt);
            List<int[]> arr = sortMap.get(genre);
        
            int x = arr.get(0)[1];
            answerList.add(x);
            if(arr.size()>1){
                int y = arr.get(1)[1];
                answerList.add(y);
            }
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();

    }
}