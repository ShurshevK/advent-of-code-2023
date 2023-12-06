import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> download() throws IOException {
        List<String> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
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
            char first = 0;
            char last = 0;
            for (int i = 0; i < line.length(); i++) {
                // if first time seen true;
                char current = line.charAt(i);
                if (Character.isDigit(current)) {
                    first = current;
                    break;
                }
            }
            for (int j = line.length()-1; j >= 0; j--) {
                char current = line.charAt(j);
                if (Character.isDigit(current)) {
                    last = current;
                    break;
                }
            }
            sum += Integer.parseInt(String.valueOf(first) + String.valueOf(last));
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(calculate());
    }
}