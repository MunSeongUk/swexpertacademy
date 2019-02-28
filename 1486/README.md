# 1486. 장훈이의 높은 선반
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw&categoryId=AV2b7Yf6ABcBBASw&categoryType=CODE)
<hr />
input 값이 <br/>
5 16<br/>
1 3 3 5 6<br/>
인 경우, 1 3 3 5 6 으로 만들 수 있는 모든 조합 중<br/>
16이상인 가장 작은 조합을 구하면 된다.<br/>
16 < 3 + 3 + 5 + 6 = 17 ... success<br/>
16 < 1 + 3 + 3 + 5 + 6 = 18 ... 16이상인 값중 가장 작은 수가 아님<br/>
16 > 1 + 3 + 5 + 6 = 15 ... fail<br/>
<br />
이 문제 역시 완전 탐색으로 가능한 모든 조합을 검색하면 쉽게 풀 수 있다.

<pre><code>
public class Solution {
	public static int N;
	public static int B;
	public static int[] staff;
	public static int[] answer;
	public static int sizeOfAnswer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			N = Integer.valueOf(token[0]);
			B = Integer.valueOf(token[1]);
			
			staff = new int[N];
			answer = new int[1 << N];
			sizeOfAnswer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; st.hasMoreTokens(); ++i) {
				staff[i] = Integer.valueOf(st.nextToken());
			}
			
			dfs(0, 0);
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < sizeOfAnswer; ++i) {
				if (answer[i] < min) {
					min = answer[i];
				}
			}

			System.out.println("#" + test_case + " " + min);
		}
		
		br.close();
	}
	
	public static void dfs(int idx, int tall) {
		if (idx == N) {
			if (tall >= B) {
				answer[sizeOfAnswer++] = tall - B;
			}
			
			return;
		}
		
		dfs(idx + 1, tall + staff[idx]);
		dfs(idx + 1, tall);
	}
}
</pre></code>