import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a,b)-> a-b);
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b)-> b-a);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String operation: operations){
            String[] arr = operation.split(" ");
            if(arr[0].equals("I")){
                int num = Integer.parseInt(arr[1]);
                minQ.add(num);
                maxQ.add(num);
                map.put(num, map.getOrDefault(num, 0)+1);
            }else{
                if(arr[1].equals("1")){
                    while(!maxQ.isEmpty() && map.get(maxQ.peek())==0){
                        maxQ.poll();
                    }
                    if(!maxQ.isEmpty()){
                        int num = maxQ.poll();
                        map.put(num, map.get(num)-1);
                    }
                }else{
                    while(!minQ.isEmpty() && map.get(minQ.peek())==0){
                        minQ.poll();
                    }
                    if(!minQ.isEmpty()){
                        int num = minQ.poll();
                        map.put(num, map.get(num)-1);
                    }
                }
            }
        }
        while(!maxQ.isEmpty() && map.get(maxQ.peek())==0){
            maxQ.poll();
        }
        while(!minQ.isEmpty() && map.get(minQ.peek())==0){
            minQ.poll();
        }
        if(minQ.isEmpty() && maxQ.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{maxQ.poll(), minQ.poll()};
    }
}