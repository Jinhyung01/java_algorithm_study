import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int i1 = Integer.parseInt(new StringBuilder(a).reverse().toString());
        int i2 = Integer.parseInt(new StringBuilder(b).reverse().toString());
        System.out.print(Math.max(i1, i2));
    }
}