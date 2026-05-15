import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            Form[] forms = new Form[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                forms[i] = new Form(s, e);
            }
            Arrays.sort(forms);
            int cnt = 0;
            int end = 0;
            for (int i = 0; i < N; i++) {
                if (end <= forms[i].s) {
                    end = forms[i].e;
                    cnt++;
                }
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    public static class Form implements Comparable<Form> {
        int s, e;

        public Form(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Form o) {
            if (this.e == o.e) {
                return Integer.compare(this.s, o.s);
            }
            return Integer.compare(this.e, o.e);
        }
    }
}
