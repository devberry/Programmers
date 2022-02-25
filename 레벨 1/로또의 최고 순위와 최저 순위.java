class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correct = 0;
        int zero = 0;
        
        for(int l : lottos) {
            if(l == 0)
                zero++;
        }
              
        for(int i = 0; i < win_nums.length; i++) {
            for(int j = 0; j < lottos.length; j++) {
                if(win_nums[i] == lottos[j]) {
                    correct++;
                    break;
                }
            }
        }
        
        switch(correct + zero) {
            case 6:
                answer[0] = 1;
                break;
            case 5:
                answer[0] = 2;
                break;
            case 4:
                answer[0] = 3;
                break;
            case 3:
                answer[0] = 4;
                break;
            case 2:
                answer[0] = 5;
                break;
            default:
                answer[0] = 6;
                break;
        }
        
        switch(correct) {
            case 6:
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;
            case 4:
                answer[1] = 3;
                break;
            case 3:
                answer[1] = 4;
                break;
            case 2:
                answer[1] = 5;
                break;
            default:
                answer[1] = 6;
                break;
        }
        
        return answer;
    }
}
