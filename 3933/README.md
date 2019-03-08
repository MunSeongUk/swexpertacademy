# 7103. 준홍이의 네 개의 제곱수
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkImrCqBeoDFAXC)
<hr />
라그랑주 네 제곱수: 

[위키](https://ko.wikipedia.org/wiki/%EB%9D%BC%EA%B7%B8%EB%9E%91%EC%A3%BC%EC%9D%98_%EB%84%A4_%EC%A0%9C%EA%B3%B1%EC%88%98_%EC%A0%95%EB%A6%AC)

쟈코비의 네 제곱수:

[위키](https://wiki.mathnt.net/index.php?title=%EC%9E%90%EC%BD%94%EB%B9%84%EC%9D%98_%EB%84%A4_%EC%A0%9C%EA%B3%B1%EC%88%98_%EC%A0%95%EB%A6%AC)
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