# 1494. 사랑의 카운슬러
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b_WPaAEIBBASw&categoryId=AV2b_WPaAEIBBASw&categoryType=CODE)
<hr />
문제 해석이 참 난감한데, 지렁이 A:(6,0)와 B:(3,3), C:(-7,2), D:(-4,-1)가 있다고 가정하자<br/>
A지렁이가 B지렁이에게 이동한다고 하면 x축으로 -3, y축으로 3만큼 이동한것이다.<br/>
C지렁이가 D지렁이에게 이동한다고 하면 x축으로 3, y축으로 -3만큼 이동한것이다.<br/>
따라서, 두 케이스의 이동거리를 합해주면 총 x축으로 0, y축으로 0이 나오므로 벡터의 합은 0이다<br/>
But, B->A로 이동하면 x축으로 3, y축으로 -3이고 B->A, C->D의 이동합은 6, -6이므로 벡터의 합은 72가 된다.<br/>
이동방향을 조심해야 한다.<br/>
<br/>
해결방안을 설명하기 위해 움직이는 지렁이를 남자 지렁이, 움직이지 않는 지렁이를 여자 지렁이라고 하자<br/>
남자 지렁이의 번호 Ax, 여자 지렁이의 번호 Bx<br/>
이동거리의 합 : (A1 - B1) + (A2 - B2) + (A3 - B3) + (A4 - B4) + (A5 - B5)<br/>
이 수식은 다음과 같이 변형가능하다 : (A1 + A2 + A3 + A4 + A5) - (B1 + B2 + B3 + B4 + B5)<br/>
따라서, Ax 자리에 넣을 수 있는 조합만 구하면 자동으로 Bx 자리는 채워지기 때문에<br/>
지렁이 수가 N이라고 한다면 Combination(N/2, 2)로 쉽게 접근할 수 있다.<br/>
<br />

<pre><code>
public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			sb.append("#").append(test_case).append(" ");

			N = Integer.parseInt(br.readLine());
			worms = new int[N][2];
			scores = new long[100000000];
			sizeOfScores = 0;
			
			for (int i = 0; i < N; ++i) {
				token = br.readLine().split(" ");
				worms[i][0] = Integer.valueOf(token[0]);
				worms[i][1] = Integer.valueOf(token[1]);
			}

			isSelected = new boolean[worms.length];
			combinationUtil(worms.length, worms.length / 2, 0, 0);
			
			min = Long.MAX_VALUE;
			for (int i = 0; i < sizeOfScores; ++i) {
				if (scores[i] < min) {
					min = scores[i];
				}
			}
			sb.append(min).append('\n');
		}

		System.out.println(sb);
	}

	static void combinationUtil(int n, int r, int index, int i) {
		if (index == r) {
			long x = 0, y = 0;
			for (int j = 0; j < worms.length; ++j) {
				if (isSelected[j]) {
					x += worms[j][0];
					y += worms[j][1];
				} else {
					x -= worms[j][0];
					y -= worms[j][1];
				}
			}
			scores[sizeOfScores++] = x * x + y * y;
			
			return; 
		} 

		if (i >= n) { return; }

		isSelected[i] = true;
		combinationUtil(n, r, index+1, i + 1); 
		isSelected[i] = false;
		combinationUtil(n, r, index, i + 1); 
	} 
}
</pre></code>