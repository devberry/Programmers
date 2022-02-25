import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> set = new HashSet<>();
        int correct = 0;
        int zero = 0;
        
        for(int l : lottos) {
            set.add(l);
            if(l == 0)
                zero++;
        }
              
        for(int win : win_nums) {
            if(set.contains(win))
                correct++;
        }
        
        answer[0] = Math.min(7 - (correct + zero), 6);
        answer[1] = Math.min(7 - correct, 6);
        
        return answer;
    }
}
