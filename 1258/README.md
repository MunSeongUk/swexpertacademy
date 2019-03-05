# 1258. [S/W 문제해결 응용] 7일차 - 행렬찾기
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18LoAqItcCFAZN&categoryId=AV18LoAqItcCFAZN&categoryType=CODE)
<hr />
사각형의 범위를 찾는 방법은 bfs를 이용한다.<br/>
bfs의 시작 노드가 startX, startY 라고 한다면<br/>
bfs의 끝 노드는 endX, endY가 된다. <br/>
이를 이용해 사각형의 범위를 잡은 후 크기-행 순으로 정렬한다.
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