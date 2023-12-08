import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<String> numberWords = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    public static List<String> download() throws IOException {
        List<String> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("day1/data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataList.add(line);
            }
        }
        return dataList;
    }

    public static int calculate() throws IOException {
        List<String> data = download();
        int sum = 0;
        for (String line : data) {
            String first = "";
            String last = "";
            String string = "";
            for (int i = 0; i < line.length(); i++) {
                // if first time seen true;
                char current = line.charAt(i);
                if (Character.isDigit(current)) {
                    first = String.valueOf(current);
                    break;
                } else {
                    string = line.substring(i);
                    first = isPartlyNumberWordReverse(string);
                    if (first != null){
                        first = stringToNumber(first);
                        break;
                    }
                }
            }
            string = "";
            for (int j = line.length()-1; j >= 0; j--) {
                char current = line.charAt(j);
                if (Character.isDigit(current)) {
                    last = String.valueOf(current);
                    break;
                } else {
                    string = line.substring(j);
                    last = isPartlyNumberWordReverse(string);
                    if (last != null){
                        last = stringToNumber(last);
                        break;
                    }
                }
            }
            int res = Integer.parseInt(first + last);
            sum += res;
        }
        return sum;

    }

    private static String stringToNumber(String string) {
        return switch (string) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> "";
        };
    }

    public static String isPartlyNumberWordReverse(String s) {
        for (String num : numberWords) {
            if (s.startsWith(num)) {
                return num;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(calculate());
    }
}
// 53866