# 6913. 동철이의 프로그래밍 대회
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWicMVWKTuMDFAUL)
<hr />
카운트만 잘하자<br/>
별다른 알고리즘은 필요없다<br />

<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			
			int N = Integer.valueOf(token[0]);
			int M = Integer.valueOf(token[1]);
			
			int iValue;
			int maxScore = Integer.MIN_VALUE;
			int count = 0;
			
			for (int i = 0; i < N; ++i) {
				token = br.readLine().split(" ");
				iValue = 0;
				for (int j = 0; j < M;  ++j) {
					if(token[j].charAt(0) - '0' == 1) {
						iValue++;
					}
				}
				if (iValue > maxScore) {
					maxScore = iValue;
					count = 1;
				} else if (iValue == maxScore) {
					count++;
				}
			}
			
			System.out.println("#" + test_case + " " + count + " " + maxScore);
		}
		
		br.close();
	}
}
</pre></code>