package programmers;

import java.util.*;

public class memoryScore {
    static class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < name.length; i++){
                map.put(name[i], yearning[i]);
            }

            for(int i = 0; i < photo.length; i++) {
                for(int j = 0; j < photo[i].length; j++){
                    if(map.containsKey(photo[i][j])){
                        int value = map.get(photo[i][j]);
                        answer[i] += value;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{{"may", "kein", "kain", "radi"},
                                {"may", "kein", "brin", "deny"},
                                {"kon", "kain", "may", "coni"}}
        );
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
