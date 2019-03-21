# 3074. 입국심사
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_XEokaAEcDFAX7&categoryId=AV_XEokaAEcDFAX7&categoryType=CODE)
<hr />
시간을 기준으로 몇 초 대에 일이 몇개 끝났는지를 검사하자<br/>
가령 7, 10인 경우 25초대에 7, 10, 14, 20, 21의 일이 끝난것이다<br/>
<br />

<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			
			int N = Integer.valueOf(token[0]);
			long M = Integer.valueOf(token[1]);
			long spend[] = new long[N];

			for (int i = 0; i < N; ++i) {
				spend[i] = Integer.valueOf(br.readLine());
			}
			
			Arrays.sort(spend);
			
			long minTime = 0;
			long maxTime = spend[spend.length - 1] * M;
			long answer = Long.MAX_VALUE;
			
			while (minTime <= maxTime) {
				long midTime = (minTime + maxTime) / 2;
				long count = 0;
				
				for (int i = 0; i < N; ++i) {
					count += (midTime / spend[i]);
				}
				
				if (count < M) {
					minTime = midTime + 1;
				} else {
					if (answer > midTime) {
						answer = midTime;
					}
					
					maxTime = midTime - 1;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		br.close();
	}
}
</pre></code>