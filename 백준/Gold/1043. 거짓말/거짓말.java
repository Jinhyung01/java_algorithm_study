import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int knownPeopleCount = Integer.parseInt(st.nextToken());
        if (knownPeopleCount == 0) {
            System.out.println(M);
            return;
        }

        int root = Integer.parseInt(st.nextToken());

        for (int i = 1; i < knownPeopleCount; i++) {
            union(root, Integer.parseInt(st.nextToken()));
        }

        int[] parties = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pCount = Integer.parseInt(st.nextToken());
            parties[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < pCount; j++) {
                union(parties[i], Integer.parseInt(st.nextToken()));
            }
        }
        int cnt = 0;
        for (int i = 0; i < parties.length; i++) {
            if (find(parties[i]) != find(root)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rootA < rootB) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
            }
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }


}