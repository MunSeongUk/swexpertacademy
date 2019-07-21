# 2005. 파스칼의 삼각형
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE)
<hr />
문제를 해결하기 위한 알고리즘은 다음과 같다.<br/>

1. A[n][1] = 1
2. A[n][n] = 1
3. A[n][k] = A[n -1][k - 1] + A[n - 1][k] (n, k >= 0)
<br />

<pre><code>
public class Solution {

	public static void main(String[] args) {
		int pascal[][] = new int[12][12];
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();

		

		
		for (int k = 1; k <= T; ++k) {
			System.out.println("#" + k);
			int N = scanner.nextInt();
			
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= i; ++j) {
					if (j == i) {
						pascal[i][j] = 1;
						System.out.println("1");
					} else if (j == 1) {
						pascal[i][j] = 1;
						System.out.print("1 ");
					} else {
						pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
						System.out.print(pascal[i][j] + " ");
					}
				}
					
			}
		}
		
	}

}
</pre></code>
