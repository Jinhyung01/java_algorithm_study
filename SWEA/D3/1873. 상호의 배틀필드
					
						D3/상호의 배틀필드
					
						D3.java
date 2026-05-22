import java.io.*;
import java.util.*;

public class Solution {
    // 상,하,좌,우

    static char[] dir = {'^', 'v', '<', '>'};
    static int[] pos = new int[2];
    static char[][] map;
    static int H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    for (int d = 0; d < 4; d++) {
                        if (map[i][j] == dir[d]) {
                            pos[0] = i;
                            pos[1] = j;
                        }
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            char[] ins = br.readLine().toCharArray();
            for (int i = 0; i < N; i++) {
                execute(ins[i]);
            }
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void execute(char ins) {
        int x = pos[0];
        int y = pos[1];
        switch (ins) {
            case 'U': {
                map[x][y] = '^';
                if (x - 1 >= 0 && map[x - 1][y] == '.') {
                    pos[0] = x - 1;
                    map[x - 1][y] = '^';
                    map[x][y] = '.';

                }
                break;
            }
            case 'D': {
                map[x][y] = 'v';
                if (x + 1 < H && map[x + 1][y] == '.') {
                    pos[0] = x + 1;
                    map[x + 1][y] = 'v';
                    map[x][y] = '.';
                }
                break;
            }
            case 'L': {
                map[x][y] = '<';
                if (y - 1 >= 0 && map[x][y - 1] == '.') {
                    pos[1] = y - 1;
                    map[x][y - 1] = '<';
                    map[x][y] = '.';
                }
                break;
            }
            case 'R': {
                map[x][y] = '>';
                if (y + 1 < W && map[x][y + 1] == '.') {
                    pos[1] = y + 1;
                    map[x][y + 1] = '>';
                    map[x][y] = '.';
                }
                break;
            }
            case 'S': {
                int nx = x;
                int ny = y;
                char c = map[x][y];
                if (c == '^') {
                    while (true) {
                        nx += -1;
                        if (nx < 0) break;

                        if (map[nx][y] == '*') {
                            map[nx][y] = '.';
                            break;
                        } else if (map[nx][y] == '#') {
                            break;
                        }
                    }
                } else if (c == 'v') {
                    while (true) {
                        nx += 1;
                        if (nx >= H) break;

                        if (map[nx][y] == '*') {
                            map[nx][y] = '.';
                            break;
                        } else if (map[nx][y] == '#') {
                            break;
                        }
                    }
                } else if (c == '<') {
                    while (true) {
                        ny += -1;
                        if (ny < 0) break;

                        if (map[x][ny] == '*') {
                            map[x][ny] = '.';
                            break;
                        } else if (map[x][ny] == '#') {
                            break;
                        }
                    }
                } else {
                    while (true) {
                        ny += 1;
                        if (ny >= W) break;

                        if (map[x][ny] == '*') {
                            map[x][ny] = '.';
                            break;
                        } else if (map[x][ny] == '#') {
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
}