# 5643. [Professional] 키 순서
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo&categoryId=AWXQsLWKd5cDFAUo&categoryType=CODE)
<hr />
진입차수와 진출차수의 경우를 각각 생각하면 된다.<br />

<pre><code>
public class Solution {
	public static int T;
	public static int N;
	public static int M;
	public static String[] token;
	
	public static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		T = Integer.valueOf(br.readLine().trim());

		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.valueOf(br.readLine().trim());
			M = Integer.valueOf(br.readLine().trim());
			
			map = new boolean[N + 1][N + 1];
			
			for (int i = 0; i < M; ++i) {
				token = br.readLine().trim().split(" ");
				map[Integer.valueOf(token[0])][Integer.valueOf(token[1])] = true;
			}
			
			int answer = 0;
			
			for (int i = 1; i <= N; ++i) {
				int step = 0;
				boolean[] isVisited = new boolean[N + 1];
				
//				for (int j = 1; j <= N; ++j) {
//					if (i == j) { continue; }
//					
//					if(map[i][j]) {
//						step++;
//						isVisited[j] = true;
//					}
//				}


				Stack<Integer> stack = new Stack<>();
				stack.push(i);
				isVisited[i] = true;
				
				while (!stack.isEmpty()) {
					int cur = stack.pop();
					step++;
					
					for (int j = 1; j <= N; ++j) {
						if(!isVisited[j] && map[cur][j]) {
							isVisited[j] = true;
							stack.push(j);
						}
					}
				}
				
				stack.push(i);
				step--;
				
				while (!stack.isEmpty()) {
					int cur = stack.pop();
					step++;
					
					for (int j = 1; j <= N; ++j) {
						if(!isVisited[j] && map[j][cur]) {
							isVisited[j] = true;
							stack.push(j);
						}
					}
				}
				
				if (N - step == 0) {
					answer++;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		br.close();
	}
}
</pre></code>
플루이드 와샬의 경우<br>
<pre><code>
public class Solution {
	static int N;
	static int M;
	static int[][] maps;
	static boolean[] v;
	static int result = 0;
	static int[] manCount;
	static int INF = 987654321;
	public static void main(String[] args) throws IOException{
		//		System.setIn(new FileInputStream("input_5643.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();		
			maps = new int[N+1][N+1];
			for(int i = 0; i <=N; i++) {
				Arrays.fill(maps[i], INF);
			}
			for(int i = 0 ; i < M; i++) {
				maps[sc.nextInt()][sc.nextInt()] = 1;  //행의 학생이 열의 학생보다 키가 작다.
			}
			//			서로 관련 있는 사람들을 알수있는것 변경하기(프로이드 와샬 알고리즘)
			for(int k = 1; k <=N; k++) {
				for(int i = 1; i <=N; i++) {
					for(int j = 1; j<=N;j++) {
						if(maps[i][j] > maps[i][k] + maps[k][j]) {
							maps[i][j] = maps[i][k] + maps[k][j];
						}
					}
				}
			}

			int[] isKnows = new int[N+1];
			for(int i = 1; i <=N; i++) {
				for(int j = 1; j<=N;j++) {
					if(maps[i][j] != INF) {
						isKnows[i]++;
						isKnows[j]++;
					}
				}
			}
			result = 0;
			for(int i = 1; i <=N; i++) {
				if(isKnows[i] == N-1) {
					result++;
				}
			}

			System.out.println("#" + t + " " + result);

		}
	}
}
</pre></code>