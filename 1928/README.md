# 1928. Base64 Decoder
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PR4DKAG0DFAUq&categoryId=AV5PR4DKAG0DFAUq&categoryType=CODE)
<hr />
문제를 해결하기 위한 알고리즘은 다음과 같다.<br/>

1. 입력받은 문자열의 4개의 단어를 추출
2. 인코딩 표를 이용하여 문자를 디코딩함
3. 디코딩한 문자를 6bit로 만듬
4. 6bit * 4 = 24bit를 8bit씩 나눠 3개의 문자를 만듬<br/>
	문자가 a,b,c,d 일 경우 (a&b), (b&c), (c&d) <br/>
	a의 6bit, b의 2bit = 8bit<br/>
	b의 4bit, c의 4bit = 8bit<br/>
	c의 2bit, d의 6bit = 8bit
5. 출력
<br />

<pre><code>
public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			String line = br.readLine();
			int lengthOfInput = line.length();
			int a, b, c, d;
			char x, y, z;
			StringBuilder ans = new StringBuilder();
			
			for (int i = 0; i < lengthOfInput; i += 4) {
				a = encodingTable(line.charAt(i));
				b = encodingTable(line.charAt(i + 1));
				c = encodingTable(line.charAt(i + 2));
				d = encodingTable(line.charAt(i + 3));
				
				//a의 6bit를 추출 한 후 2칸 앞으로 보내고, b의 앞 2bit를 추출하여 뒤로 4칸 보낸 후 a와 결합 = 8bit
				x = (char) (((a & 63) << 2) | ((b & 48) >> 4));
				//b의 뒤 4bit를 추출 한 후 4칸 앞으로 보내고, c의 앞 4bit를 추출하여 뒤로 2칸 보낸 후 b와 결합 = 8bit
				y = (char) (((b & 15) << 4) | ((c & 60) >> 2));
				//c의 뒤 2bit를 추출 한 후 6칸 앞으로 보내고, d의 앞 6bit를 추출하여 c와 결합 = 8bit
				z = (char) (((c & 3) << 6) | (d & 63));
				
				ans.append(x);
				ans.append(y);
				ans.append(z);
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
		
		br.close();
	}
	
	//입력받은 문자를 디코딩하기 위해 인코딩 표를 작성
	public static int encodingTable(char target) {
		if ('A' <= target && target <= 'Z') {
			return target - 'A';
		} else if ('a' <= target && target <= 'z') {
			return target - 'a' + 26;
		} else if ('0' <= target && target <= '9') {
			return target - '0' + 52;
		} else if ('+' == target) {
			return 62;
		} else if ('/' == target) {
			return 63;
		} else {
			return -1;
		}
	}
}
</pre></code>

!!! 이 문제는 꼼수가 있다...

<pre><code>
public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            String base64 = sc.next();
            String Decoder = new String(Base64.getDecoder().decode(base64));
            System.out.println("#" + test_case + " " + Decoder);
        }
    }
}
</pre></code>

Java의 Base64 라이브러리를 이용하는 것