package programmers.codingtest;

import java.util.*;

public class Camouflage {

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;

            List<String> types = new ArrayList<>();
            List<String> list;
            Map<String, List<String>> cMap = new HashMap<>();

            for (int i = 0; i < clothes.length; i++) {
                String type = clothes[i][1];
                if (cMap.containsKey(type)) {
                    List<String> typeList = cMap.get(type);
                    typeList.add(clothes[i][0]);
                    cMap.put(type,typeList);
                    answer += 1;
                } else {
                    list = new ArrayList<>();
                    list.add(clothes[i][0]);
                    types.add(type);
                    cMap.put(type, list);
                    answer += 1;
                }
            }
            if (cMap.size() != 1) {
                int rest = 1;
                for (int i = 0; i < types.size(); i++) {
                    List<String> findList = cMap.get(types.get(i));
                    rest *= findList.size() + 1;
                }
                answer += rest;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
/*
        int result = solution.solution(new String[][]{{"yellow_hat", "headgear"}
                , {"blue_sunglasses", "eyewear"}
                , {"green_turban", "headgear"}});
*/

        String[][] clothes = {
                {"동그란 안경", "얼굴"}
                , {"검정 선글라스", "얼굴"}
                , {"파란색 티셔츠", "상의"}
                , {"청바지", "하의"}
                , {"긴 코트", "겉옷"}};
        int result = solution.solution(clothes);


        System.out.println(result);

    }
}
