import java.util.*;
import java.io.*;

class Solution {
    static HashMap<String, Integer> GNS = new HashMap<>();
    static String[] str = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    static {
        for (int i = 0; i < str.length; i++) {
            GNS.put(str[i], i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String n = st.nextToken();
            int length = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] A = new int[length];
            for (int i = 0; i < length; i++) {
                A[i] = GNS.get(st.nextToken());
            }
            Arrays.sort(A);
            sb.append(n).append("\n");
            for(int i=0;i<length;i++){
                sb.append(str[A[i]]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}