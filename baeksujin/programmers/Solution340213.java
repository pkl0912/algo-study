package programmers;

public class Solution340213 {

    class Solution {

        public int getTime(String time){
            String[] times = time.split(":");
            int h = Integer.valueOf(times[0]);
            int m = Integer.valueOf(times[1]);

            m += (h * 60) ;
            return m;
        }

        public String getStringTime(int time){

            int h = time / 60;
            int m = time % 60;

            return String.format("%02d", h) + ":"+
                    String.format("%02d", m);

        }
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String answer = "";

            int n = commands.length;

            // 오프닝 skip
            int currentTime = getTime(pos);
            if( getTime(op_start) <= currentTime && getTime(op_end) >= currentTime){
                currentTime = getTime(op_end); // pos change
            }

            int vidioLen = getTime(video_len);


            // move
            for(int i=0; i<n; i++){



                String op = commands[i];


                if(op.equals("next")){
                    // +=10
                    int next = currentTime + 10;
                    if(next >= vidioLen){
                        next = vidioLen;
                    }
                    currentTime = next;
                }else if (op.equals("prev")){
                    int next = currentTime - 10;
                    if(next <=0){
                        next = 0;
                    }
                    currentTime = next;
                }

                // 오프닝 스킵
                if( getTime(op_start) <= currentTime && getTime(op_end) >= currentTime){
                    currentTime = getTime(op_end); // pos change
                }
            }


            return getStringTime(currentTime);
        }
    }
}
