public class MinimalSquare {

    static class Solution {
        public int solution(int[][] sizes) {
            int front_idx = 0;
            int back_idx = 0;

            int front_result = 0;
            int back_result = 0;

            // sizes 각 원소를 비교하여 일정 방향으로 정렬하기
            for (int[] size : sizes) {
                front_idx = size[0];
                back_idx = size[1];
                if(front_idx < back_idx) {
                    size[0] = back_idx;
                    size[1] = front_idx;
                }
            }

            for (int[] size : sizes) {
                if(front_result < size[0]){
                    front_result = size[0];
                }
                if(back_result < size[1]){
                    back_result = size[1];
                }
            }

            return front_result * back_result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        int result2 = solution.solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}});
        System.out.println(result);
        System.out.println(result2);
    }

}
