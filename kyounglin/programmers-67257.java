package kyounglin;
import java.util.*;
class Solution {
    public List<Character> ops = new ArrayList<>();
    public long max = Long.MIN_VALUE;
    public List<Long> numbers = new ArrayList<>();
    public List<Character> operations = new ArrayList<>();
    public long solution(String expression) {
        for(char c: expression.toCharArray()){
            if(!Character.isDigit(c) && !ops.contains(c)) ops.add(c);
        }
    
        NumOp(expression);
        dfs(new ArrayList<>(), expression);
        return max;
    }
    public void dfs(List<Character> selected, String expression){
        if(selected.size()==ops.size()){
            cal(selected);
            return;
        }
        for(int i = 0; i<ops.size(); i++){
            if(!selected.contains(ops.get(i))){
                selected.add(ops.get(i));
                dfs(selected, expression);
                selected.remove(selected.size()-1);
            }
        }
    }
    public void NumOp(String expression){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<expression.length()){
            if(Character.isDigit(expression.charAt(i))){
                sb.append(expression.charAt(i));
            }else{
                numbers.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
                operations.add(expression.charAt(i));
            }
            i++;
        }
        numbers.add(Long.parseLong(sb.toString()));

    }
    public void cal(List<Character> selected) {

        List<Long> nums = new ArrayList<>(numbers);
        List<Character> ops = new ArrayList<>(operations);

        for(char priority : selected){

            for(int i = 0; i < ops.size(); ){

                if(ops.get(i) == priority){

                    long result =
                        calculate(
                            nums.get(i),
                            ops.get(i),
                            nums.get(i + 1)
                        );

                    nums.set(i, result);
                    nums.remove(i + 1);
                    ops.remove(i);

                }else{
                    i++;
                }
            }
        }

        max = Math.max(max, Math.abs(nums.get(0)));
    }
    public long calculate(long a, char op, long b){
        if(op=='+') return a+b;
        if(op=='-') return a-b;
        if(op=='*') return a*b;
        else return 0;
        
    }
}