# 5550. 나는 개구리로소이다
[링크](https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWWxqfhKAWgDFAW4&)
<hr />
croak 혹은 croakcroak가 울음 한 번의 완성이고, crocroakak이면 2마리의 개구리가 존재한다.<br/>
무슨 차이냐 하면 c의 발생위치가 croak한 묶음이 끝난 후인지 전에 우는지 판단하면 된다.<br/>
crocroakak에서 두번째 c는 croak한 묶음이 끝나기 전에 발생했으므로 2마리이다.<br/>
만약, cccroakk이면 묶음이 불안정하므로 -1이된다.<br/>

<pre><code>
public class Solution {
    public static StringBuilder sb = new StringBuilder();
    public static String croaks;
    public static int[] alphabetOfCroak;
    public static LinkedList<LinkedList<Character>> sets = new LinkedList<>();
    public static LinkedList<Character> list;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.valueOf(br.readLine());

        Testcase: for (int test_case = 1; test_case <= T; ++test_case) {
            sets.clear();
            answer = 0;
            sb.append("#").append(test_case).append(" ");

            croaks = br.readLine();
            int lengthOfCroaks = croaks.length();
            char cValue;
            boolean flag = false;

            Outer: for (int i = 0; i < lengthOfCroaks; ++i) {
                cValue = croaks.charAt(i);
                if (cValue == 'c') {
                    for (int j = 0; j < sets.size(); ++j) {
                        list = sets.get(j);

                        if (list.getLast() == 'k') {
                            list.add('c');
                            continue Outer;
                        }
                    }

                    list = new LinkedList<>();
                    list.add('c');
                    sets.add(list);

                } else if (cValue == 'r') {
                    for (int j = 0; j < sets.size(); ++j) {
                        list = sets.get(j);

                        if (list.getLast() == 'c') {
                            list.add('r');
                            continue Outer;
                        }
                    }

                    sb.append("-1\n");
                    continue Testcase;
                } else if (cValue == 'o') {
                    for (int j = 0; j < sets.size(); ++j) {
                        list = sets.get(j);

                        if (list.getLast() == 'r') {
                            list.add('o');
                            continue Outer;
                        }
                    }

                    sb.append("-1\n");
                    continue Testcase;
                } else if (cValue == 'a') {
                    for (int j = 0; j < sets.size(); ++j) {
                        list = sets.get(j);

                        if (list.getLast() == 'o') {
                            list.add('a');
                            continue Outer;
                        }
                    }

                    sb.append("-1\n");
                    continue Testcase;
                } else if (cValue == 'k') {
                    for (int j = 0; j < sets.size(); ++j) {
                        list = sets.get(j);

                        if (list.getLast() == 'a') {
                            list.add('k');
                            continue Outer;
                        }
                    }

                    sb.append("-1\n");
                    continue Testcase;
                }
            }

            flag = false;

            for (int i = 0; i < sets.size(); ++i) {
                list = sets.get(i);

                if (list.getLast() != 'k') {
                    sb.append("-1\n");
                    flag = true;
                    break;
                } else {
                    answer++;
                }
            }
            if (!flag) {

                sb.append(answer).append("\n");
            }

        }

        System.out.println(sb);

        br.close();
    }
}
</pre></code>