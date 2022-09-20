import java.util.Arrays;

public class NoneCompletePlayer {
    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Arrays.sort(participant);
            Arrays.sort(completion);
            for (int i = 0; i < completion.length; i++){
                if (!participant[i].equals(completion[i])) return participant[i];
            }
            return participant[participant.length-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        System.out.println(result);
    }

}
