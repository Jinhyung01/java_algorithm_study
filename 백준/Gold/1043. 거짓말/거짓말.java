import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        people = new int[M];

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if(n==0){
            System.out.println(M);
        }else{
            int root = Integer.parseInt(st.nextToken());
            for (int i = 1; i < n; i++) {
                union(root, Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                int person = Integer.parseInt(st.nextToken());
                people[i] = person;
                for (int j = 1; j < k; j++) {
                    int nextPerson = Integer.parseInt(st.nextToken());
                    union(person, nextPerson);
                }
            }
            int result = 0;
            for (int i = 0; i < M; i++) {
                if (find(root) != find(people[i])) {
                    result++;
                }
            }
            System.out.print(result);
        }
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