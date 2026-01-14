import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        System.out.print(Math.max(reverseInt(a), reverseInt(b)));

    }
    // "123" -> 321로바꿀려면 뒤에서부터 읽고 result에 10씩 곱해줘야함
    static int reverseInt(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result = result * 10 + s.charAt(i) - '0';
        }
        return result;
    }
}