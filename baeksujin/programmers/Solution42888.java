package programmers;
import java.util.*;
public class Solution42888 {
    class Solution {
        public String[] solution(String[] record) {
            ArrayList<String> answer = new ArrayList<>();


            HashMap<String, String> nickName =  new HashMap<>();
            for(String r : record){

                String[] data = r.split(" ");
                String action = data[0];
                String userId = data[1];


                if(action.equals("Enter") || action.equals("Change")){
                    String userName = data[2];
                    // 1. name save - put map
                    nickName.put(userId, userName);
                }
            }



            for(String r : record){
                String[] data = r.split(" ");
                String action = data[0];
                String userId = data[1];
                String userName = nickName.get(userId);

                if(action.equals("Enter")){
                    String result = userName + "님이 들어왔습니다.";
                    answer.add(result);
                }
                if(action.equals("Leave")){
                    String result = userName + "님이 나갔습니다.";
                    answer.add(result);
                }

            }


            return answer.toArray(new String[0]);
        }
    }



}
