public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            answer[i] = "";
        }
        // 이진수 스트링값으로 담아줄 배열
        String[] sarr1 = new String[n];
        String[] sarr2 = new String[n];

        // 이진수로 변환된 String을 가지고 있는 배열 2개 생성
        for(int i = 0 ; i < n; i++){
            String s1 = String.valueOf(Integer.toBinaryString(arr1[i]));
            if(s1.length() < n){
                int zero = n - s1.length();
                for(int j = 0 ; j < zero; j++){
                    s1 = "0" + s1;
                }
            }
            String s2 = String.valueOf(Integer.toBinaryString(arr2[i]));
            if(s2.length() < n){
                int zero = n - s2.length();
                for(int j = 0 ; j < zero; j++){
                    s2 = "0" + s2;
                }
            }
            sarr1[i] = s1;
            sarr2[i] = s2;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if (String.valueOf(sarr1[i].charAt(j)).equals("1")) {
                    answer[i] += "#";
                } else {
                    if (String.valueOf(sarr2[i].charAt(j)).equals("1")) {
                        answer[i] += "#";
                    } else {
                        answer[i] += " ";
                    }
                }
            }
        }
        
        return answer;
    }
    public static void main(String[] args) {
        SecretMap secretMap = new SecretMap();

        String[] solution = secretMap.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
