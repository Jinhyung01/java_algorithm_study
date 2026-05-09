import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            List<Integer> nums = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(nums);


            sb.append("#").append(t).append(" ");
            int n = nums.size();
            for (int i = 0; i < 5; i++) {
                sb.append(nums.get(n - i - 1)).append(" ").append(nums.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
