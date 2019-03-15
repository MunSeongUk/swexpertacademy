import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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