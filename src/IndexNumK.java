import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IndexNumK {
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i = 0; i < commands.length; i++){
                answer[i] = Arrays.stream(Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1])).sorted()
                        .boxed().collect(Collectors.toList()).get(commands[i][2] - 1);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : solution1) {
            System.out.print(i); //5 6 3
        }
    }
}
