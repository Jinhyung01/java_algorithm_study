import java.io.*;
import java.util.*;

public class Main {

    static int[] minimum = new int[4];
    static int[] current = new int[4];
    static char[] dna;
    static int cond = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        dna = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) cond++;
            minimum[i] = n;
        }
        for (int i = 0; i < P; i++) {
            add(i);
        }
        if (cond == 4) result++;

        int i = 0, j = P;
        while (j < S) {
            add(j);
            remove(i);
            if (cond == 4) result++;
            j++;
            i++;
        }
        System.out.println(result);
    }

    private static void remove(int i) {
        char c = dna[i];
        switch (c) {
            case 'A': {
                if (current[0] == minimum[0]) {
                    cond--;
                }
                current[0]--;
                break;
            }
            case 'C': {
                if (current[1] == minimum[1]) {
                    cond--;
                }
                current[1]--;
                break;
            }
            case 'G': {
                if (current[2] == minimum[2]) {
                    cond--;
                }
                current[2]--;
                break;
            }
            case 'T': {
                if (current[3] == minimum[3]) {
                    cond--;
                }
                current[3]--;
                break;
            }
        }
    }


    private static void add(int i) {
        char c = dna[i];
        switch (c) {
            case 'A': {
                current[0]++;
                if (current[0] == minimum[0]) {
                    cond++;
                }
                break;
            }
            case 'C': {
                current[1]++;
                if (current[1] == minimum[1]) {
                    cond++;
                }
                break;
            }
            case 'G': {
                current[2]++;
                if (current[2] == minimum[2]) {
                    cond++;
                }

                break;
            }
            case 'T': {
                current[3]++;
                if (current[3] == minimum[3]) {
                    cond++;
                }
                break;
            }
        }
    }
}