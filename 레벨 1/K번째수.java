import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        
        for(int[] c : commands) {
            int[] temp = Arrays.copyOfRange(array, c[0] - 1, c[1]);
            Arrays.sort(temp);
            answer[i++] = temp[c[2] - 1];
        }
        
        return answer;
    }
}

/*
i 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands
o commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return
c array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
e

sol
1.
배열을 자르고 정렬한 뒤 k번째 숫자를 구한다.

time O(m*nlogn) n==array.length m==commands.length
space O(n)
*/
