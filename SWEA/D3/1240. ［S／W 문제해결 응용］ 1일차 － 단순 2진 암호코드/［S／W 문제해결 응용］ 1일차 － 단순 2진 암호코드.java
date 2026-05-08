import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static String[] nums = {"0001101", "0011001", "0010011", "0111101", "0100011",
            "0110001", "0101111", "0111011", "0110111", "0001011"};

    static {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int endIndex = -1, startIndex = -1;
            int oddSum = 0;
            int evenSum = 0;
            int result = 0;
            boolean isProcess = false;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                if (!isProcess && str.contains("1")) {
                    isProcess = true;
                    for (int j = M - 1; j >= 0; j--) {
                        if (str.charAt(j) == '1') {
                            endIndex = j;
                            break;
                        }
                    }
                    startIndex = endIndex - 56 + 1;
                    for (int j = startIndex, n = 1; j <= endIndex; j += 7, n++) {
                        int num = map.get(str.substring(j, j + 7));
                        if (n % 2 == 0) {
                            evenSum += num;
                        } else {
                            oddSum += num;
                        }
                    }
                    if ((oddSum * 3 + evenSum) % 10 == 0) {
                        result = oddSum + evenSum;
                    }
                }

            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);

    }
}