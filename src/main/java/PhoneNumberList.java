import java.util.Arrays;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }
        return answer;
    }

    public static void main(String[] args) {
        PhoneNumberList phoneNumberList = new PhoneNumberList();
        phoneNumberList.solution(new String[]{"123", "456", "789"});
    }
}