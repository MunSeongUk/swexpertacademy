# 1976. 시각덧셈
[링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PttaaAZIDFAUq&categoryId=AV5PttaaAZIDFAUq&categoryType=CODE)
<hr />
문제를 해결하기 위한 알고리즘은 다음과 같다.<br/>

1. 분을 더한 후 합이 60을 넘어갈 경우 1시간을 더하고 60분을 뺀다.
2. 시간을 더하고 합이 24를 넘어갈 경우 12시간을 뺀다.
<br />

<pre><code>
public class Solution {
	public static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			int hour = 0, minute = 0;
			
			int tHour1, tHour2, tMinute1, tMinute2;
			tHour1 = sc.nextInt();
			tMinute1 = sc.nextInt();
			tHour2 = sc.nextInt();
			tMinute2 = sc.nextInt();
			
			
			minute = tMinute1 + tMinute2;
			if (minute >= 60) {
				minute -= 60;
				hour++;
			}
			

			hour = hour + tHour1 + tHour2;
			
			if (hour >= 13) {
				hour -= 12;
			}
			
			System.out.println("#" + test_case + " " + hour + " " + minute);
		}
		
		
		sc.close();
	}

}
</pre></code>