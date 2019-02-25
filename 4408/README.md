# 4408. 자기 방으로 돌아가기
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcJ2sapZMDFAV8&categoryId=AWNcJ2sapZMDFAV8&categoryType=CODE)
<hr />
우선 방을 이동하는 경로를 잘 생각해보면<br />
1->6 : 2->6, 398->201 : 398->202<br />
두 경우가 같다는 걸 알 수 있다.
즉 방을 찾아갈 때 위 아래가 중요한게 아니라 가로 경로를 얼마나 점유하고 있냐가 중요하다. 1->2, 60->53 같은 경우는 1, 4 칸의 복도를 차지하고 있다고 생각해보면 방향을 반대로 바꿔도 차지하는 칸의 수는 똑같다는걸 알 수 있다.
<br />
따라서, 데이터를 입력 받을 때 홀수-홀수로 통일하거나 짝수-짝수의 방번호로 통일하면 방을 저장하는 배열의 크기를 반으로 줄일 수 있다.
<pre><code>
public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("sample_input.txt"));
		
		//테스트 케이스의 수
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			//학생의 수
			int N = sc.nextInt();
			
			int from, to;
			int[] room = new int[201]; //방의 개수
			
			for (int i = 0; i < N; ++i) {
				from = sc.nextInt();
				to = sc.nextInt();
				
				//이동 경로가 10->4인 경우, 4->10과 같은 경로임.
				if (from > to) {
					int temp = from;
					from = to;
					to = temp;
				}
				
				//홀 수 번째 방을 배정받았으면, 짝수 번째의 방으로 변경
				if ((from & 1) == 1) { from++; }
				if ((to & 1) == 1) { to++; }
				
				//복도 번호와 매칭하기 위해서
				from /= 2;
				to /= 2;
				
				//시작 방 부터 끝 방까지 몇 번 복도를 밟았는지 계산
				for (int path = from; path <= to; ++path) {
					room[path]++;
				}
			}
			
			int answer = 0;
			
			//복도를 밟은 횟수는 몇번의 이동이 일어 났는지 알려주는 지표이다.
			for (int i = 1; i <= 200; ++i) {
				if (answer < room[i]) {
					answer = room[i];
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		sc.close();
	}

}
</pre></code>