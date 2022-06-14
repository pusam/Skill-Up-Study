import java.util.ArrayList;
import java.util.List;

public class BiggestNumber {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int number : numbers)
            list.add(String.valueOf(number));

        list.sort((a, b) -> (b + a).compareTo(a + b));

        for (String s : list)
            answer.append(s);

        String result = answer.toString();
        return result.startsWith("0") ? "0" : result;
    }

    public static void main(String[] args) {
        BiggestNumber biggestNumber = new BiggestNumber();
        biggestNumber.solution(new int[]{0, 0, 0, 0});
    }
}