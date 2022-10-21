public class RecommendNewId {
    static class Solution {
        public String solution(String new_id) {
            String answer = "";

            answer = capToSmall(new_id);
            answer = removeLetters(answer);
            answer = checkDots(answer);
            answer = checkBothEdges(answer);
            // 5단계
            if(answer.length() == 0){
                answer += "a";
            }
            answer = checkLength(answer);
            answer = ifShorterThanTwo(answer);

            return answer;
        }

        // 7단계
        private String ifShorterThanTwo(String answer) {
            String result = "";
            char add = answer.charAt(answer.length() - 1);
            if(answer.length() < 3){
                result = answer;
                while(result.length() < 3){
                    result += String.valueOf(add);
                }
            } else {
                result = answer;
            }
            return result;
        }

        // 6단계
        private String checkLength(String answer) {
            String result = "";
            if(answer.length() > 15){
                for(int i = 0; i < 15; i++){
                    result += String.valueOf(answer.charAt(i));
                }
            } else {
                result = answer;
            }
            return checkBothEdges(result);
        }

        // 4단계
        private String checkBothEdges(String answer) {
            String result = "";
            for(int i = 0; i < answer.length(); i++){
                char checkDot = answer.charAt(i);
                if(i == 0 && checkDot == '.' || i == answer.length() -1 && checkDot == '.'){
                    continue;
                } else {
                    result += checkDot;
                }
            }
            return result;
        }

        // 3단계
        private String checkDots(String answer) {
            String result = "";
            for(int i = 0; i < answer.length()-1; i++){
                char preidx = answer.charAt(i);
                char backidx = answer.charAt(i+1);
                if(backidx == '.' && preidx == '.' && preidx == backidx){
                    continue;
                } else {
                    result += String.valueOf(preidx);
                }
            }
            if(!(answer.charAt(answer.length()-1) == '.')){
                result += String.valueOf(answer.charAt(answer.length() - 1));
            }
            return result;
        }

        // 2단계
        private String removeLetters(String answer) {
            String result = "";
            for(int i = 0; i < answer.length(); i++){
                char idx = answer.charAt(i);
                if((idx >= 'a' && idx <= 'z') || (idx >= '0' && idx<= '9') || idx == '-' || idx == '_' || idx == '.'){
                    result += String.valueOf(idx);
                }
            }
            return result;
        }

        // 1단계
        private String capToSmall(String new_id) {
            String result = "";
            for(int i = 0; i < new_id.length(); i++){
                char idx = new_id.charAt(i);
                if(idx >= 'A' && idx <= 'Z'){
                    result += String.valueOf((char)(idx + 32));
                } else {
                    result += String.valueOf(idx);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("...!@BaT#*..y.abcdefghijklm");
        String result2 = solution.solution("z-+.^.");
        String result3 = solution.solution("=.=");
        String result4 = solution.solution("123_.def");
        String result5 = solution.solution("abcdefghijklmn.p");
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }
}
