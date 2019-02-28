# 5215. 햄버거 다이어트
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT)
<hr />
입력받은 햄버거가 a, b, c라고 하자 그러면 a, b, c로 만들 수 있는 조합을 만들면 된다.<br />
a<br/>
b<br/>
c<br/>
a, b<br/>
a, c<br/>
b, c<br/>
a, b, c<br/>
<br />
이 문제는 완전탐색의 한 종류이며 DP, Powerset, dfs 등 다양한 방법으로 풀 수 있다.<br/>
나는 powerset으로 접근<br/>

<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			int N = Integer.valueOf(token[0]);
			int MAX_CALORIE = Integer.valueOf(token[1]);
			
			//0: 맛에 대한 점수, 1: 칼로리
			int[][] hamburger = new int[N][2];
			
			for (int i = 0; i < N; ++i) {
				token = br.readLine().split(" ");
				hamburger[i][0] = Integer.valueOf(token[0]);
				hamburger[i][1] = Integer.valueOf(token[1]);
			}
			
			int powersetSize = 1 << N;
	        int[][] combi = new int[powersetSize][2];
	        int sizeOfCombi = 0;
			
	        //햄버거 조합의 모든 경우의 수를 검색
			for (int i = 0; i < N; ++i) {
				int curSize = sizeOfCombi;
				for (int j = 0; j < curSize; ++j) {
					//만약 칼로리가 MAX를 넘을 경우, 해당 조합을 고려하지 않음
					//만약 a, b 조합이 칼로리가 1000일 경우 여기에 c를 더해봐야 1000 + 알파
					if (combi[j][1] + hamburger[i][1] <= MAX_CALORIE) {
						combi[sizeOfCombi][0] += combi[j][0] + hamburger[i][0];
						combi[sizeOfCombi++][1] += combi[j][1] + hamburger[i][1];
					}
				}
				combi[sizeOfCombi][0] = hamburger[i][0];
				combi[sizeOfCombi++][1] = hamburger[i][1];
			}
			
			//점수를 기준으로 내림차순 정렬
			Arrays.sort(combi, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o2[0] - o1[0];
				}
			});

			System.out.println("#" + test_case + " " + combi[0][0] );
		}
		
		br.close();
	}
}
</pre></code>