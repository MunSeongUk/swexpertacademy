# 4408. 자기 방으로 돌아가기
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcJ2sapZMDFAV8&categoryId=AWNcJ2sapZMDFAV8&categoryType=CODE)
<hr />
같이 돌아갈 수 있는 학생을 1개의 팀으로 생각하면 최악의 케이스는 N개의 팀이 생성된다. 만약, (1,2) : (3,4) : (5,6)인 경우 3명의 학생은 한 번에 같이 돌아갈 수 있으므로 1개의 팀으로 묶어 처리할 수 있다.
그래서 나는 입력받은 순서에 따라 같이 돌아갈 수 있는지 검사하여 팀을 만들어 총 몇팀이 만들어지는지를 계산하여 이 문제를 해결하려고 하였다.

<pre><code>
class Room {
	public int index;
	public int from, to;
	
	public Room(int index, int from, int to) {
		super();
		
		this.index = index;
		
		if (to < from) {
			this.from = to;
			this.to = from;
		} else {
			this.from = from;
			this.to = to;
		}
	}
	
	public boolean collide(Room obj) {
		if (this.to < obj.from || this.from > obj.to) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "" + index;
	}
}

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("sample_input.txt"));

		int T = Integer.valueOf(sc.nextInt());
		sc.nextLine();
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = sc.nextInt();
			
			int from, to;
			
			ArrayList<ArrayList<Room>> corridor = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				corridor.add(new ArrayList<>());
			}
			
			Room room;
			
			for (int i = 0; i < N; ++i) {
				from = sc.nextInt();
				to = sc.nextInt();
				
				if ((from & 1) == 1) {
					from++;
				}
				
				if ((to & 1) == 1) {
					to++;
				}
				
				room = new Room(i, from, to);
				
				TEAM: for (int j = 0; j < N; ++j) {
					int length = corridor.get(j).size();

					if (length == 0) {
						corridor.get(j).add(room);
						break;
					} else {
						for (int k = 0; k < length; ++k) {
							if (corridor.get(j).get(k).collide(room)) {
								continue TEAM;
							}
						}
						
						corridor.get(j).add(room);
						break TEAM;
					}
				}
			}
			
			int result = 0;
			for (int i = 0; i < N; ++i) {
				if (corridor.get(i).size() > 0) { result++; }
			}
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
}
</code></pre>