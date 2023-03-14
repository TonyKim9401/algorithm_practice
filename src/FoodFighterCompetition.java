import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FoodFighterCompetition {
    public static String solution(int[] food) {
        String answer = "";

        HashMap<Integer, Integer> posQty = new HashMap<>();
        posQty.put(0, 1);
        for(int i = 1; i < food.length; i++) {
            if(food[i] % 2 == 0) {
                posQty.put(i, food[i] / 2);
            } else {
                if(food[i] - 1 == 1) continue;
                posQty.put(i, (food[i] - 1) / 2);
            }
        }

        for (Integer integer : posQty.keySet()) {
            if(integer == 0) continue;
            for(int i = 0; i < posQty.get(integer); i++) {
                answer += String.valueOf(integer);
            }
        }

        return answer + "0" + new StringBuffer(answer).reverse();

        /*String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i;
            }
        }

        return answer;*/
    }
    public static void main(String[] args) {
        String solution = FoodFighterCompetition.solution(new int[]{1,3,4,6});
        String solution2 = FoodFighterCompetition.solution(new int[]{1,7,1,2});
        System.out.println("solution = " + solution);
        System.out.println("solution2 = " + solution2);
    }
}
