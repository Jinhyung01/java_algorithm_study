import java.util.*;
import java.io.*;

class Solution {
    static List<Integer> nums;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            nums = new LinkedList<>();
            String str = st.nextToken();
            for (int i = 0; i < str.length(); i++) {
                nums.add(str.charAt(i) - '0');
            }
            for (int i = 0; i < N; i++) {
                int k = 0;
                while (i - k >= 0 && i + 1 + k < nums.size() && nums.get(i - k) == nums.get(i + 1 + k)) {
                    k++;
                }
                for (int j = 0; j < 2 * k; j++) {
                    nums.remove(i - k + 1);
                }
                if(k!=0){
                    i=0;
                }
            }
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < nums.size(); i++) {
                sb.append(nums.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}