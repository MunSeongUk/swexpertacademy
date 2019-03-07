# 1210. [S/W 문제해결 기본] 2일차 - Ladder1
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE)
<hr />
출발 지점을 다 조사하지 말고, 끝 지점을 기준으로 어디로 나오는지 조사해보자<br/>

<pre><code>
public class Solution {
    public static StringBuilder sb = new StringBuilder();
    public static String token[];
    public static boolean map[][];
    public static int cur[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

        for (int test_case = 1; test_case <= 10; ++test_case) {
            sb.append("#").append(test_case).append(" ");

            br.readLine();

            map = new boolean[100][102];
            cur = new int[2];

            for (int i = 0; i < 100; ++i) {
                token = br.readLine().split(" ");
                for (int j = 0; j < 100; ++j) {
                    if (Integer.valueOf(token[j]) == 1) {
                        map[i][j + 1] = true;
                    } else if (Integer.valueOf(token[j]) == 2) { // 시작 위치 설정
                        cur[0] = i;
                        cur[1] = j + 1;
                    }
                }
            }

            cur[0]--;

            while (cur[0] != 0) {
                if (map[cur[0]][cur[1] - 1]) {
                    while (map[cur[0]][cur[1] - 1]) {
                        cur[1]--;
                    }
                } else if (map[cur[0]][cur[1] + 1]) {
                    while (map[cur[0]][cur[1] + 1]) {
                        cur[1]++;
                    }
                }
                cur[0]--;
            }

            sb.append(cur[1] - 1).append("\n");
        }


        System.out.print(sb);

        br.close();
    }
}
</pre></code>