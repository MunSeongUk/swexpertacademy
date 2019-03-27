import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("input.txt"));

        int T = 10;

        for (int test_case = 1; test_case <= T; ++test_case) {
            int N = sc.nextInt();
            int arr[] = new int[100];


            for (int i = 0; i < 100; ++i) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            while (N > 0) {
                arr[99]--;
                arr[0]++;

                for (int i = arr.length - 1; i > 0; --i) {
                    if (arr[i] < arr[i - 1]) {
                        int tmp = arr[i];
                        arr[i] = arr[i - 1];
                        arr[i - 1] = tmp;
                    }
                }

                for (int i = 0; i < arr.length - 1; ++i) {
                    if (arr[i] > arr[i + 1]) {
                        int tmp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = tmp;
                    }
                }

                N--;
            }

            System.out.println("#" + test_case + " " + (arr[arr.length - 1] - arr[0]));
        }

        sc.close();
    }
}
