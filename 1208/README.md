# 1208. [S/W 문제해결 기본] 1일차 - Flatten
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh)
<hr />
높이를 기준으로 배열에 저장한다음, 배열을 정렬한다.<br/>
가장 처음 인덱스가 가장 낮은거, 가장 끝 인덱스가 가장 높은거를 의미하므로<br/>
처음을 1더하고, 끝을 1뺀 후 처음과 끝의 위치를 조정한다<br/>
삽입정렬의 원리를 생각하면 쉽게 이해할 수 있다.<br/>

<pre><code>
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("input.txt"));

        int T = 10;

        for (int test_case = 1; test_case <= T; ++test_case) {
            int N = sc.nextInt();
            int arr[] = new int[100];


            for (int i = 0; i < 100; ++i) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            while (N > 0) {
                arr[99]--;
                arr[0]++;

                for (int i = arr.length - 1; i > 0; --i) {
                    if (arr[i] < arr[i - 1]) {
                        int tmp = arr[i];
                        arr[i] = arr[i - 1];
                        arr[i - 1] = tmp;
                    }
                }

                for (int i = 0; i < arr.length - 1; ++i) {
                    if (arr[i] > arr[i + 1]) {
                        int tmp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = tmp;
                    }
                }

                N--;
            }

            System.out.println("#" + test_case + " " + (arr[arr.length - 1] - arr[0]));
        }

        sc.close();
    }
}
</pre></code>