import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
