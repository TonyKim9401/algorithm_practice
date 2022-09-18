import java.util.*;

public class FaultRate {
    static class Solution {
        public int[] solution(int N, int[] stages) {

            Map<Integer, Double> result = new HashMap<>();
            int count = 0;
            int divisor = 0;

            /*
            * 스테이지별 실패률 구하기
            * */
            for(int i = 1; i <= N; i++){
                divisor = 0;
                count = 0;
                for(int j = 0; j < stages.length; j++){
                    if(stages[j] < i) {
                        count++;
                        continue;
                    }
                    if(stages[j] == i) divisor++;
                }
                if(divisor == 0){
                    result.put(i, 0.0);
                } else {
                    if (i <= N) {
                        result.put(i, ((double) divisor / (double) (stages.length - count)) * 100);
                    }
                }
            }

            /*
            * 실패율에 따라 Comparator 를 사용해 내림차순 정렬
            * */
            List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(result.entrySet());
            Collections.sort(entryList, new Comparator<Map.Entry<Integer, Double>>() {
                @Override
                public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            for (Map.Entry<Integer, Double> i : entryList) {
                System.out.println("key= " + i.getKey() + " value = " + i.getValue());
            }
            /*
            * key 값을 int 배열로 반환
            * */
            return entryList.stream().mapToInt(i -> i.getKey()).toArray();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[] result = solution.solution(5, new int[]{2,1,2,6,2,4,3,3});
        for (int i : result) {
            System.out.print(i + " ");
        }*/
        int[] result2 = solution.solution(3, new int[]{1,1,1});
        for (int i : result2) {
            System.out.print(i + " ");
        }
    }
}
