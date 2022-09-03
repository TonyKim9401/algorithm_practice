import java.util.ArrayList;
import java.util.List;

public class DartGame {
    public static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            String num = "";
            int index = 0;
            int cur = 0;
            int[] arr = new int[3];

            for(int i = 0; i < dartResult.length(); i++) {

                char value = dartResult.charAt(i);

                if (value >= '0' && value <= '9') {
                    num += String.valueOf(value);
                } else if(value == 'S' || value == 'D' || value == 'T'){
                    cur = Integer.parseInt(num);
                    arr[index] = cur;
                    index++;
                    if (value == 'S') {
                        arr[index - 1] = (int) Math.pow(arr[index - 1], 1);
                    } else if (value == 'D') {
                        arr[index - 1] = (int) Math.pow(arr[index - 1], 2);
                    } else if (value == 'T') {
                        arr[index - 1] = (int) Math.pow(arr[index - 1], 3);
                    }
                    num = "";
                    cur = 0;
                } else {
                    if (value == '#') {
                        arr[index - 1] *= -1;
                    } else if (value == '*') {
                        if (index > 1) {
                            arr[index - 1] *= 2;
                            arr[index - 2] *= 2;
                        } else {
                            arr[index - 1] *= 2;
                        }
                    }
                }
            }

            for(int i = 0; i < arr.length; i++){
                answer += arr[i];
            }



            return answer;

        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("1S2D*3T"));
        System.out.println(sol.solution("1D2S0T"));
        System.out.println(sol.solution("1S*2T*3S"));
        System.out.println(sol.solution("1D#2S*3S"));
        System.out.println(sol.solution("1T2D3D#"));
        System.out.println(sol.solution("1D2S3T*"));
        System.out.println(sol.solution("1D2S#10S"));

    }
}
