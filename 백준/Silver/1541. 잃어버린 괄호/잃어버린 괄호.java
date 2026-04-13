import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int n = st.countTokens();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            String str = st.nextToken();
            if (str.contains("+")) {
                String[] s = str.split("\\+");
                for(int j=0;j<s.length;j++){
                    nums[i] += Integer.parseInt(s[j]);
                }
            } else {
                nums[i] = Integer.parseInt(str);
            }
        }
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            result -= nums[i];
        }
        System.out.println(result);

    }
}