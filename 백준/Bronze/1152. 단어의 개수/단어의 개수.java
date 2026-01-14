import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int cnt = 0;
        boolean inWord = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c != ' ') {
                if (!inWord) {
                    cnt++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }
        System.out.print(cnt);
    }
}
