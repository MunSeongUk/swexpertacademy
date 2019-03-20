# 3143. 가장 빠른 문자열 타이핑
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_65wkqsb4DFAWS)
<hr />
문자열을 기준으로 검색을 하다가 단축 글자의 첫글자랑 같은경우<br/>
비교해주면서 건너띄자<br/>
<br/>

<pre><code>
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
</pre></code>