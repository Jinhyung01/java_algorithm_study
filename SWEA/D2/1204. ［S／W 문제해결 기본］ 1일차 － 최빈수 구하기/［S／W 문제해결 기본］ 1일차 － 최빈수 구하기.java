import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int tNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] score = new int[101];

            for (int i = 0; i < 1000; i++) {
                score[Integer.parseInt(st.nextToken())]++;
            }
            int maxCount = score[0];
            int maxScore = 0;
            for (int i = 1; i <= 100; i++) {
                if (maxCount <= score[i]) {
                    maxCount = score[i];
                    maxScore = i;
                }
            }
            sb.append("#").append(tNum).append(" ").append(maxScore).append("\n");
        }
        System.out.print(sb);
    }
}