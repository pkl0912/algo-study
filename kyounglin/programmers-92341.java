package kyounglin;

import java.util.*;
import java.time.*;

class Solution {
    public Map<String, String> inMap = new HashMap<>();
    public Map<String, Integer> timeMap = new TreeMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        for(String record: records){
            String[] arr = record.split(" ");
            String time = arr[0];
            String car = arr[1];
            if(arr[2].equals("IN")){
                inMap.put(car, time);
            }else{
                LocalTime startTime = LocalTime.parse(inMap.get(car));
                LocalTime endTime = LocalTime.parse(time);
                int minutes = (int) Duration.between(startTime, endTime).toMinutes();
                
                int totalTime = timeMap.getOrDefault(car, 0)+minutes;
                timeMap.put(car, totalTime);
                inMap.remove(car);
            }
        }
        for(String car: inMap.keySet() ){
            LocalTime startTime = LocalTime.parse(inMap.get(car));
            LocalTime endTime = LocalTime.parse("23:59");
            int minutes = (int) Duration.between(startTime, endTime).toMinutes();
            int totalTime = timeMap.getOrDefault(car, 0)+minutes;
            System.out.println(car+" "+" "+startTime+" "+totalTime);
            timeMap.put(car, totalTime);
        }
        
        List<Integer> result = new ArrayList<>();

        for (String car : timeMap.keySet()) {

            int totalTime = timeMap.get(car);

            int fee = fees[1];

            if (totalTime > fees[0]) {
                fee += ((totalTime - fees[0] + fees[2] - 1) / fees[2]) * fees[3];
            }

            result.add(fee);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}