import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        //우선순위 정의
        String[][] rank = 
        {{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},{"*","+","-"},{"*","-","+"}};
        
        //연산자, 피연산자 구분
        List<String> list = new ArrayList<>();
        
        int start = 0;
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if(ch == '+' || ch == '-' || ch == '*') {
                list.add(expression.substring(start, i));
                list.add(Character.toString(ch));
                
                start = i + 1;
            }
        }
        list.add(expression.substring(start));
        
        //우선순위에 따라 연산
        for(int i = 0; i < rank.length; i++) {
            List<String> tempList = new ArrayList(list);
            
            for(int j = 0; j < rank[0].length; j++) {
                for(int k = 0; k < tempList.size(); k++) {
                    if(tempList.get(k).equals(rank[i][j])) {
                        tempList.set(k - 1, calc(tempList.get(k), tempList.get(k - 1), tempList.get(k + 1)));
                        tempList.remove(k);
                        tempList.remove(k);
                        k--;
                    }
                }   
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(tempList.get(0))));
        }
        
        return answer;
    }
    
    public String calc(String op, String num1, String num2) {
        long longNum1 = Long.parseLong(num1);
        long longNum2 = Long.parseLong(num2);
        
        if(op.equals("+")) {
            return Long.toString(longNum1 + longNum2);
        } else if(op.equals("-")) {
            return Long.toString(longNum1 - longNum2);
        }
        
        return Long.toString(longNum1 * longNum2);
    }
}

/*
+, -, *
+, *, -
-, +, *
-, *, +
*, +, -
*, -, +
6가지의 경우를 모두 다 구현
*/
