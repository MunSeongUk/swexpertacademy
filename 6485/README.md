# 6485. 삼성시의 버스 노선
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWczm7QaACgDFAWn&categoryId=AWczm7QaACgDFAWn&categoryType=CODE)
<hr />
문제가 생각보다 쉽다...<br/>
버스가 가는 노선은 선형적으로 움직이기 때문에 배열의 처음과 끝을 잡고 포문으로 탐색하면서 방문회수를 증가시켜주면 된다.
<br />

<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("s_input.txt")));
		int T = Integer.valueOf(br.readLine());
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = Integer.valueOf(br.readLine());
			
			//정류장의 최대 개수는 5000개이다.
			int[] busStop = new int[5001];
			String[] token;
			
			for (int i = 0; i < N; ++i) {
				token = br.readLine().split(" ");
				
				//버스가 가는 노선은 선형적이기 때문에 (ex: 1->2->3->4) 시작구간, 끝 구간을 알고있으면 중간경로는 쉽게 구할 수 있다.
				for (int j = Integer.valueOf(token[0]); j <= Integer.valueOf(token[1]); ++j) {
					busStop[j]++;
				}
			}
			
			int P = Integer.valueOf(br.readLine());
			
			System.out.print("#" + test_case + " ");
			
			for (int i = 0; i < P; ++i) {
				System.out.print(busStop[Integer.valueOf(br.readLine())] + " ");
			}
			
			System.out.println();
		}
		
		br.close();
	}
}
</pre></code>