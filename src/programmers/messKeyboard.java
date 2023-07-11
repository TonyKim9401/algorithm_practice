package programmers;

import java.util.*;

public class messKeyboard {
    static class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            boolean check;
            Map<Character, Integer> key = new HashMap<>();

            for(int i = 0; i < keymap.length; i++) {
                String keyboard = keymap[i];
                for(int j = 0; j < keyboard.length(); j++) {
                    char value = keyboard.charAt(j);
                    if(key.containsKey(value)) {
                        if(key.get(value) > j) {
                            key.put(value, j + 1);
                        }
                    } else {
                        key.put(value, j + 1);
                    }
                }
            }
            for(int i = 0; i < targets.length; i++) {
                String target = targets[i];
                check = true;
                for(int j = 0; j < target.length(); j++) {
                    char targetChar = target.charAt(j);
                    if(key.containsKey(targetChar)) answer[i] += key.get(targetChar);
                    else {check = false; break;}
                }
                answer[i] = check == false? -1 : answer[i];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] result = solution.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"});
        int[] result = solution.solution(new String[]{"AGZ","AA" , "BSSS"}, new String[]{"ASA","B", "BGZ"});
        System.out.print("result = ");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
