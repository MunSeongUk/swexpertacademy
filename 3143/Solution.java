import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader(new File("sample_input.txt")));
		int T = Integer.valueOf(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] token = br.readLine().split(" ");
			String origin = token[0];
			String shortcut = token[1];
			
			int length = origin.length();
			int sLength = shortcut.length();
			char cValue;
			
			int count = 0;
			int tmpCnt = 0;
			
			if (sLength > length) {
				System.out.println("#" + test_case + " " + length);
				continue;
			}
			
			for (int i = 0; i < length; ++i) {
				cValue = origin.charAt(i);
				count++;
				
				if (cValue == shortcut.charAt(0) && length - i >= sLength) {
					tmpCnt = 0;
					for (int j = 1; j < sLength; ++j) {
						if (origin.charAt(i + j) != shortcut.charAt(j)) {
							break;
						}
						tmpCnt++;
					}
					if (tmpCnt == sLength - 1) {
						i += sLength - 1;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + count);
		}
		
		br.close();
	}
}