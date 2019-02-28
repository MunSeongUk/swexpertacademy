# 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh)
<hr />
다음과 같은 수 분포가 있으면: 10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3 <br/>
10이 1번, 9가 1번, 8이 4번, ... 이렇듯 8이 최빈수이다.<br/>
<br />

<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br 	= new BufferedReader(new FileReader("input.txt"));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = Integer.valueOf(br.readLine());
			String[] token = br.readLine().split(" ");
			int[] rank = new int[101];
			
			for (int i = 0; i < token.length; ++i) {
				rank[Integer.valueOf(token[i])]++;
			}
			
			int max = 1, maxIdx = 0;
			
			for (int i = 0; i < 101; ++i) {
				if (max < rank[i]) {
					max = rank[i];
					maxIdx = i;
				}
			}
			
			int[] arr = new int[101];
			int sizeOfArr = 0;
			
			for (int i = 0; i < 101; ++i) {
				if (rank[i] == rank[maxIdx]) {
					arr[sizeOfArr++] = i;					
				}
			}
			
			max = 1;
			
			for (int i = 0; i < sizeOfArr; ++i) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			
			System.out.println("#" + N + " " + max);
		}
		
		br.close();
	}
}
</pre></code>