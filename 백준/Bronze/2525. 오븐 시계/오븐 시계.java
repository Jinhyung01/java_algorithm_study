import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int needTime = Integer.parseInt(br.readLine());

        int time = h*60 + m;
        time += needTime;

        if (time >=24 * 60) {
            time -= (24 * 60);
        }
        System.out.println(time / 60 + " " + time % 60);

    }
}