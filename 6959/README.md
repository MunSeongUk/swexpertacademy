# 6959. 이상한 나라의 덧셈게임
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWjlH0k63joDFAVT&categoryId=AWjlH0k63joDFAVT&categoryType=CODE)
<hr />
문제를 해결하기 위한 알고리즘은 다음과 같다.<br/>

1. 문자열로 입력받아, 앞 자리의 두 숫자를 뽑아 더한다음 다시 넣는다.
2. 문자열의 길이가 1일 때 까지 반복한다.
<br />

<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br 	= new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));

		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			StringBuilder sb = new StringBuilder(br.readLine());
			int a, b;
			int step = 1;
			
			while (sb.length() != 1) {
				a = sb.charAt(0) - '0';
				sb.delete(0, 1);
				b = sb.charAt(0) - '0';
				sb.delete(0, 1);
				sb.append(a + b);
				step++;
			}
			
			if ((step & 1) == 1) {
				System.out.println("#" + test_case + " B");
			} else {
				System.out.println("#" + test_case + " A");
			}
		}
		br.close();
	}
}
</pre></code>

앞자리의 두 개를 더하나, 뒷 자리의 두 개를 더하나, 가운데의 두 개를 더하나<br/>
결과는 모두 같다... 덧셈의 결합법칙을 생각해보자.