import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long minX = Integer.MAX_VALUE;
        long maxX = Integer.MIN_VALUE;
        long minY = Integer.MAX_VALUE;
        long maxY = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            if (minX > x)
                minX = x;
            if (maxX < x)
                maxX = x;
            if (minY > y)
                minY = y;
            if (maxY < y)
                maxY = y;
        }
        long result = (maxX - minX) * (maxY - minY);
        System.out.println(result);
    }
}