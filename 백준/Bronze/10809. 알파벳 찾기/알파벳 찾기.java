import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            if (i > 'a')
                sb.append(' ');
            sb.append(str.indexOf(i));
        }
        System.out.print(sb);
    }
}
