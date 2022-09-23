import java.util.ArrayList;
import java.util.List;

public class PickupDolls {
    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            List<Integer> selectedNum = new ArrayList<>();
            int lastPosition = 0;
            boolean check = true;

            // moves를 하나씩 조회
            for(int k = 0; k < moves.length; k++) {

                // n * n 배열을 하나씩 확인
                for (int i = 0; i < board.length; i++) {
                    if(check) {
                        for (int j = 0; j < board[i].length; j++) {
                            // 행과 position의 위치가 같을때(크래들 위치)
                            if (moves[k] - 1 == j) {
                                // 좌표값이 0이면 continue;
                                if (board[i][j] != 0) {
                                    // 좌표값이 0이 아니면 selectedNum에 추가하고 좌표값을 0으로 바꿈
                                    selectedNum.add(board[i][j]);
                                    board[i][j] = 0;
                                    check = false;
                                }
                            }
                        }
                    }
                }
                check = true;
                // selectNum 분석 마지막과 마지막 전을 비교
                if(selectedNum.size() < 2) {
                    continue;
                } else {
                    int temp = selectedNum.size() - 1;
                    if(selectedNum.get(temp) == selectedNum.get(temp-1)){
                        answer += 2;
                        selectedNum.remove(temp);
                        selectedNum.remove(temp-1);
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[][]{{0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});
        System.out.println(result);
    }
}
