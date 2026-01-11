import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M >= 45) {
            M = M - 45;
        } else {
            H = H - 1;
            M = M + 15;
            if (H < 0)
                H = 23;
        }
        System.out.print(H + " " + M);
    }
}