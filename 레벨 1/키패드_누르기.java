import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Map<String, int[]> keyPos = new HashMap<>();
        keyPos.put("1", new int[]{0,0});
        keyPos.put("2", new int[]{0,1});
        keyPos.put("3", new int[]{0,2});
        keyPos.put("4", new int[]{1,0});
        keyPos.put("5", new int[]{1,1});
        keyPos.put("6", new int[]{1,2});
        keyPos.put("7", new int[]{2,0});
        keyPos.put("8", new int[]{2,1});
        keyPos.put("9", new int[]{2,2});
        keyPos.put("*", new int[]{3,0});
        keyPos.put("0", new int[]{3,1});
        keyPos.put("#", new int[]{3,2});

        int[] curLeft = {3,0};
        int[] curRight = {3,2};

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0 || numbers[i] % 3 == 2) {
                int[] dest = new int[2];
                dest[0] = keyPos.get(Integer.toString(numbers[i]))[0];
                dest[1] = keyPos.get(Integer.toString(numbers[i]))[1];

                int sumLeft = Math.abs(curLeft[0] - dest[0]) + Math.abs(curLeft[1] - dest[1]);
                int sumRight = Math.abs(curRight[0] - dest[0]) + Math.abs(curRight[1] - dest[1]);

                if(sumLeft == sumRight) {
                    if(hand.equals("right")) {
                        curRight[0] = dest[0];
                        curRight[1] = dest[1];
                        answer.append("R");
                    } else {
                        curLeft[0] = dest[0];
                        curLeft[1] = dest[1];
                        answer.append("L");
                    }
                } else if(sumLeft < sumRight) {
                    curLeft[0] = dest[0];
                    curLeft[1] = dest[1];
                    answer.append("L");
                } else {
                    curRight[0] = dest[0];
                    curRight[1] = dest[1];
                    answer.append("R");
                }

            } else if(numbers[i] % 3 == 1) {
                curLeft[0] = keyPos.get(Integer.toString(numbers[i]))[0];
                curLeft[1] = keyPos.get(Integer.toString(numbers[i]))[1];
                answer.append("L");
            } else if(numbers[i] % 3 == 0) {
                curRight[0] = keyPos.get(Integer.toString(numbers[i]))[0];
                curRight[1] = keyPos.get(Integer.toString(numbers[i]))[1];
                answer.append("R");
            }
        }

        System.out.println(answer.toString());

        return answer.toString();
    }
}

/*
i 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand
o 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return
c numbers 배열의 크기는 1 이상 1,000 이하입니다.
numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
hand는 "left" 또는 "right" 입니다.
"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
e

sol
1.

time O(n)
space O(n)
*/
