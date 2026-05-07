import java.util.*;
import java.io.*;

class Solution {
    static char[] num;
    static int totalSwap;
    static int max;
    static HashSet<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = st.nextToken().toCharArray();
            totalSwap = Integer.parseInt(st.nextToken());
            visited = new HashSet<>();
            max = 0;
            dfs(0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int curSwap) {
        int curNum = getCurNum();
        if (!visited.add(String.valueOf(curNum) + curSwap)) {
            return;
        }

        if (curSwap == totalSwap) {
            max = Math.max(max, curNum);
            return;
        }

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                swap(i, j);
                dfs(curSwap + 1);
                swap(i, j);
            }
        }
    }

    private static int getCurNum() {
        int curNum = 0;
        for (int i = 0; i < num.length; i++) {
            curNum = curNum * 10 + num[i] - '0';
        }
        return curNum;
    }

    private static void swap(int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}

