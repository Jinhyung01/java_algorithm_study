import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean isGroup = true;
            boolean[] visited = new boolean[26];
            char left = 0;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c != left) {
                    if (visited[c - 'a']) {
                        isGroup = false;
                        break;
                    }
                    visited[c - 'a'] = true;
                    left = c;
                }
            }
            if (isGroup) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}