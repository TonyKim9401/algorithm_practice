public class PrimeNumber {
    public static class Solution {
        public int solution(int n) {
            int answer = 0;

            //에라스토네테스의 체 사용(효율성 높음)
            //배열에서 1이면 소수, 1이면 세기
            int[] arr = new int[n+1];
            for(int i=0; i<=n; i++){
                arr[i] = i;
            }
            arr[1] = 0; // arr[0] = 0, arr[1] = 1이니 0으로 고쳐준다(1은 소수가 아니다)
            for(int i=2; i<=n; i++){
                if(arr[i] == 0) continue;
                for(int j = i*2; j<=n; j +=i){
                    arr[j] = 0;
                }
            }

            for(int i=0; i<n+1; i++){
                if(arr[i] != 0){
                    answer++;
                }
            }

            /*
            개인적으로 생각한 소수판별(효율성 낮고 시간 오래걸림)
            int count = 0;
               for(int i=1; i<=n; i++){
                for(int j=1; j<=i; j++){
                    if(i%j == 0) count++;
                }
                if(count == 2) answer++;
                count=0;
            }*/

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(13));
    }
}
