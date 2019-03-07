# 1206. [S/W 문제해결 기본] 1일차 - View
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh)
<hr />
가장 높은 빌딩을 기준으로 잡아서, 천장을 깍는 개념으로 접근<br/>

<pre><code>
public class Solution {
    public static StringBuilder sb = new StringBuilder();
    public static int sizeOfBuilding;
    public static StringTokenizer tokenizer;
    public static int buildings[];
    public static int sizeOfView;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

        for (int test_case = 1; test_case <= 10; ++test_case) {
            sb.append("#").append(test_case).append(" ");
            sizeOfBuilding = Integer.valueOf(br.readLine());
            buildings = new int[sizeOfBuilding + 4];
            tokenizer = new StringTokenizer(br.readLine(), " ");
            sizeOfView = 0;
            int ceiling = Integer.MIN_VALUE;

            for (int i = 2; i <= sizeOfBuilding; ++i) {
                buildings[i] = Integer.valueOf(tokenizer.nextToken());

                if (ceiling < buildings[i]) {
                    ceiling = buildings[i];
                }
            }

            ArrayList<Integer> indices = new ArrayList<>();

            while (ceiling > 0) {
                for (int i = 2; i <= sizeOfBuilding; ++i) {
                    if (buildings[i] == ceiling) {
                        if (buildings[i - 2] < ceiling && buildings[i - 1] < ceiling && buildings[i + 1] < ceiling && buildings[i + 2] < ceiling) {
                            sizeOfView++;
                        }
                        indices.add(i);
                    }
                }

                for (int i = 0; i < indices.size(); ++i) {
                    buildings[indices.get(i)]--;
                }

                ceiling--;
                indices.clear();
            }

            sb.append(sizeOfView).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

</pre></code>