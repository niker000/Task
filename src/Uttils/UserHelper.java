package Uttils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UserHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static boolean answer;
    public static boolean isContinue() throws IOException {
        while (true) {
            String str = bufferedReader.readLine();
            if (str.equalsIgnoreCase("n")
                    || str.equalsIgnoreCase("no")) {
                break;
            } else if (str.equalsIgnoreCase("y")
                    || str.equalsIgnoreCase("yes")) {
                answer = true;
                break;
            } else {
                PrintHelper.print("Enter y/yes or n/no");
            }
        }
        return answer;
    }
}
