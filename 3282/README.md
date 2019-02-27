# 3282. 0/1 Knapsack
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJAVpqrzQDFAWr&categoryId=AWBJAVpqrzQDFAWr&categoryType=CODE)
<hr />
DP에 관한 가장 기본적인 문제<br />
(Dynamic Programming을 모르면 먼저 공부부터 하자)<br />

해당 문제는 완전탐색으로도 해결할 수 있지만 문제는 시간이 너무 오래 걸린다.<br />
완전탐색은 모든 부분집합을 구하는 경우와 같으므로<br />
만약 item이 n개이면 O(2의n승)이다.<br/>
하지만 이 문제를 DP로 접근하면 O(N * W:(고려해야할 무게))이다.
<br />

<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			int N = Integer.valueOf(token[0]);
			int capacity = Integer.valueOf(token[1]);
			
			capacity++;
			N++;
			
			// 0: 부피, 1: 가치
			int[][] items = new int[N][2];
			items[0][0] = 0; 
			items[0][1] = 0;
			
			for (int i = 1; i < N; ++i) {
				token = br.readLine().split(" ");
				items[i][0] = Integer.valueOf(token[0]); //부피
				items[i][1] = Integer.valueOf(token[1]); //가치
			}
			
			//DP 테이블
			int[][] K = new int[N][capacity];
			
			for (int i = 1; i < N; ++i) {
				for (int w = 1; w < capacity; ++w) {
					if (items[i][0] > w) {
						K[i][w] = K[i - 1][w];
					} else {
						K[i][w] = Math.max(K[i - 1][w - items[i][0]] + items[i][1], K[i - 1][w]);
					}
				}
			}

			System.out.println("#" + test_case + " " + K[N-1][capacity-1] );
		}
		
		br.close();
	}
}
</pre></code>