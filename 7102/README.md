# 7102. 준홍이의 카드놀이
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIlHWqBYcDFAXC)
<hr />
N과 M중 큰 수가 M이라면 가장 많이 발생하는 수는 N + 1을 포함한 M - N개 만큼 연속된 수이다<br />
예를 들어 M = 6, N = 4이라면 N + 1 = 5와 M - N = 2 이므로 5, 6, 7이 답이된다.<br />

<pre><code>
public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("sample_input.txt"));
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if (N > M) {
				int tmp = N;
				N = M;
				M = tmp;
			}
			
			int answer[] = new int[1 + M - N];
			answer[0] = N + 1;
			
			for (int i = 1; i <= M - N; ++i) {
				answer[i] = answer[i - 1] + 1;
			}
			
			System.out.print("#" + test_case + " ");
			
			for (int i = 0; i < answer.length; ++i) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
</pre></code>