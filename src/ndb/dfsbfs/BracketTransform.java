package ndb.dfsbfs;

public class BracketTransform {
    public static class Solution {

        private int getIdx(String p) {
            int count = 0;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '(') count += 1;
                else count -= 1;
                if (count == 0) return i;

            }
            return -1;
        }

        private boolean validate(String p) {
            int count = 0;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '(') count += 1;
                else {
                    if (count == 0) return false;
                    count -= 1;
                }
            }
            return true;
        }

        public String solution(String p) {
            String answer = "";

            if (p.equals("") || p == null) return "";

            int idx = getIdx(p);
            String u = p.substring(0, idx + 1);
            String v = p.substring(idx + 1);

            if (validate(p)) {
                answer = u + solution(v);
            } else {
                answer = "(";
                answer += solution(v);
                answer += ")";
                u = u.substring(1, u.length() - 1);
                for (int i = 0; i < u.length(); i++) {
                    if (u.charAt(i) == '(') answer += ")";
                    else answer += "(";
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String result = solution.solution(")(");
        String result = solution.solution("()))((()");
        System.out.println(result);
    }
}
