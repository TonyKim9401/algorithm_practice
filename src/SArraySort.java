import java.util.*;

public class SArraySort {
    public static class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = new String[strings.length];

            ArrayList<String> index = new ArrayList<>();
            for(int i=0; i<strings.length; i++){
                if(!index.contains(String.valueOf(strings[i].charAt(n)))){
                    index.add(String.valueOf(strings[i].charAt(n)));
                }
            }
            Collections.sort(index);
            System.out.println(index.size());

            ArrayList<String> temp = null;
            int lo = 0;
            for(int j=0; j<index.size(); j++) {
                temp = new ArrayList<>();
                for (int i = 0; i < strings.length; i++) {
                    String ex = String.valueOf(strings[i].charAt(n));
                    if(index.get(j).equals(ex)){
                        temp.add(strings[i]);
                    }
                }
                Collections.sort(temp);

                for(int i=0; i<temp.size(); i++){
                    answer[lo] = temp.get(i);
                    lo++;
                }
            }

            for(String str : answer){
                System.out.println(str);
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = new String[]{"abce","abcd","cdx"};
        sol.solution(arr,2);

    }
}
