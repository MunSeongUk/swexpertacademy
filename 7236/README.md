# 7236. 저수지의 물의 총 깊이 구하기
[링크](https://www.swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWlTKTUqCN8DFAVS&categoryId=AWlTKTUqCN8DFAVS&categoryType=CODE)
<hr />
W의 위치를 저장하여, 8방향에 W가 있는지 조사하면 쉽다.<br />

<pre><code>
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

	T = Integer.parseInt(br.readLine());

	for (int test_case = 1; test_case <= T; ++test_case) {
		sb.append("#").append(test_case).append(" ");
		sizeOfWater = 0;
		sizeOfDepth = 0;
		
		N = Integer.valueOf(br.readLine());
		map = new boolean[N + 2][N + 2];
		locOfWater = new int[N * N][2];
		depth = new int[N * N];
		
		for (int i = 1; i <= N; ++i) {
			token = br.readLine().split(" ");
			for (int j = 1, k = 0; j <= N; ++j, ++k) {
				cValue = token[k].charAt(0);
				if(cValue == 'W') {
					map[i][j] = true;
					locOfWater[sizeOfWater][0] = i;
					locOfWater[sizeOfWater++][1] = j;
				}
			}
		}
		
		int x, y, count;
		
		for (int i = 0; i < sizeOfWater; ++i) {
			count = 0;
			
			for (int j = 0; j < 8; ++j) {
				y = locOfWater[i][0] + dir[j][0];
				x = locOfWater[i][1] + dir[j][1];

				if (map[y][x] == true) {
					count++;
				}
			}
			
			if (count == 0) {
				count++;
			}
			
			depth[sizeOfDepth++] = count;
		}
		
		int max = -1;
		
		for (int i = 0; i < depth.length; ++i) {
			if (depth[i] > max) {
				max = depth[i];
			}
		}
		
		sb.append(max).append("\n");
		
	}

	System.out.println(sb);
}
</pre></code>