import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            char[] searchWord = br.readLine().toCharArray();
            char[] str = br.readLine().toCharArray();

            int cnt = 0;
            for (int i = 0; i <=str.length - searchWord.length; i++) {
                int idx = i;
                for (int j = 0; j < searchWord.length; j++) {
                    if (str[idx] == searchWord[j]) {
                        idx++;
                    } else {
                        break;
                    }
                    if (j == searchWord.length - 1) {
                        cnt++;
                    }
                }
            }
            sb.append("#").append(T).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}