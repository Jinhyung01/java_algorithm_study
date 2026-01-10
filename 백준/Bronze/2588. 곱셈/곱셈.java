import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int C = A * (B%10);
        int D = A * ((B%100)/10);
        int E = A * (B/100);

        int result = C+ D*10 + E*100;

        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(result);
    }
}