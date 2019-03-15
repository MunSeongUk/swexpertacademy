# 7193. 승현이의 수학공부
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWksRkI6AR0DFAVE)
<hr />
나머지 연산 법칙을 잘 활용하자<br />
 ( a + m ) % m = a % m <br/>
<br/>
 ( (a % m) + ( b % m) ) % m = ( a + b ) % m <br/>
<br/>
 ( ( a % m) * ( b % m) ) % m = ( a * b) % m <br />
<br/>
<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			
			int number_system = Integer.valueOf(token[0]);
			String base = token[1];
			
			number_system--;
			long answer = 0;
			int length = base.length();
			
			for (int i = 0; i < length; ++i) {
				answer += (base.charAt(i) - '0');
			}
			
			System.out.println("#" + test_case + " " + answer % number_system);
		}
		
		br.close();
	}
}
</pre></code>