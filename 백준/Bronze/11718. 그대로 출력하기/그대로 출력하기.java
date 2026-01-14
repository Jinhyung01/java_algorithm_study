import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line =br.readLine())!=null) {
            sb.append(line).append("\n");
        }
        System.out.print(sb);
    }
}