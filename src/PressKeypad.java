import java.util.Arrays;
import java.util.List;

public class PressKeypad {
    static class Solution {
        public String solution(int[] numbers, String hand) {

            String result = "";

            int[] leftHand = new int[]{3,0};
            int[] rightHand = new int[]{3,2};
            int[] nowNode = new int[2];

            for (int number : numbers) {
                int leftNode = (number - 1) / 3;
                int rightNode = (number - 1) % 3;
                if(number == 0){
                    leftNode = 3;
                    rightNode = 1;
                }

                nowNode[0] = leftNode;
                nowNode[1] = rightNode;

                if(rightNode == 0){
                    result += "L";
                    leftHand[0] = leftNode;
                    leftHand[1] = rightNode;
                } else if(rightNode == 2){
                    result += "R";
                    rightHand[0] = leftNode;
                    rightHand[1] = rightNode;
                } else {
                    int leftDist = Math.abs(leftHand[0] - nowNode[0]) + Math.abs(leftHand[1] - nowNode[1]);
                    int rightDist = Math.abs(rightHand[0] - nowNode[0]) + Math.abs(rightHand[1] - nowNode[1]);

                    if(leftDist > rightDist){
                        result += "R";
                        rightHand[0] = leftNode;
                        rightHand[1] = rightNode;
                    } else if(leftDist < rightDist){
                        result += "L";
                        leftHand[0] = leftNode;
                        leftHand[1] = rightNode;
                    } else {
                        if(hand.equals("right")){
                            result += "R";
                            rightHand[0] = leftNode;
                            rightHand[1] = rightNode;
                        } else {
                            result += "L";
                            leftHand[0] = leftNode;
                            leftHand[1] = rightNode;
                        }
                    }

                }

            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        String result2 = solution.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        String result3 = solution.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
