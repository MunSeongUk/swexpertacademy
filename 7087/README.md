# 7087. 문제 제목 붙이기
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIdD46A5EDFAXC&categoryId=AWkIdD46A5EDFAXC&categoryType=CODE)
<hr />
입력 단어의 앞 글자만 필요하기 때문에 A-Z까지 배열을 만든 후<br/>
앞 글자의 수를 카운팅 한다.<br />

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