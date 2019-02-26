import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
