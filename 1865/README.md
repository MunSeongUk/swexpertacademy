# 1865. 동철이의 일 분배
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LuHfqDz8DFAXc&categoryId=AV5LuHfqDz8DFAXc&categoryType=CODE)
<hr />
작업자의 작업 순서를 순열로 구하여 해당 일에 대한 모든 경우의 수를 구해주면 된다.
어떤 방식으로 백트래킹할 지만 잘 생각해보자..
<br/>

<pre><code>
public class Solution {
	public static int N;
	public static int worker[];
	public static double works[][];
	public static double max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.valueOf(br.readLine());
			max = Double.MIN_VALUE;
			works = new double[N][N];
			worker = new int[N];
			String[] token;
			
			for (int i = 0; i < N; ++i) {
				token = br.readLine().split(" ");
				worker[i] = i;
				for (int j = 0; j < N; ++j) {
					works[i][j] = Double.valueOf(token[j]) * 0.01;
				}
			}
			
			permutation(0, 0, worker.length - 1, 100);
			
			System.out.printf("#%d %.6f\n", test_case, max);
		}
		
		br.close();
	}
	
	public static void permutation(int idx, int l, int r, double probability) {
		if (probability <= max) {
            return;
		}

		
		if (l == r) {
			probability *= works[idx][worker[l]];
			
			if (probability > max) {
				max = probability;
			}
			
			return;
		}
		
		for (int i = l; i <= r; ++i) {
			int tmp = worker[l];
			worker[l] = worker[i];
			worker[i] = tmp;
			
			permutation(idx + 1, l + 1, r, probability * works[idx][worker[l]]);
			
			tmp = worker[l];
			worker[l] = worker[i];
			worker[i] = tmp;
		}
	}
	
	public static void dfs(double arr[], int idx, double possibility) {
		if (idx == N) {
			if (max < possibility) {
				max = possibility;
			}
			
			return;
		}
		
		if (possibility == 0) {
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			if (i != idx) {
				dfs(arr, idx + 1, possibility * works[idx][i]);
			}
		}
	}
}
</pre></code>