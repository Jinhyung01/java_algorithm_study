import java.io.*;
import java.util.*;

public class Main {
    static final int START = 11111111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = START;
        while (st.hasMoreTokens()) {
            int temp = 0;
            String str = st.nextToken();
            String[] s = str.split("\\+");
            for (String n : s) {
                temp += Integer.parseInt(n);
            }
            if (result == START) {
                result = temp;
            } else {
                result -= temp;
            }
        }
        System.out.println(result);
    }
}