import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiveUpUser
{
    //문제 : https://programmers.co.kr/learn/courses/30/lessons/42840
    public int[] solution(int[] answers)
    {
        int[] user1 = {1, 2, 3, 4, 5};
        int[] user2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] user3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] userAnswers = {0, 0, 0};
        for (int i = 0; i < answers.length; i++)
        {
            if (answers[i] == user1[i % 5])
                userAnswers[0] = ++userAnswers[0];
            if (answers[i] == user2[i % 8])
                userAnswers[1] = ++userAnswers[1];
            if (answers[i] == user3[i % 10])
                userAnswers[2] = ++userAnswers[2];
        }

        int max = Arrays.stream(userAnswers).max().getAsInt();
        List<Integer> answer = new ArrayList<>();
        if (userAnswers[0] == max)
            answer.add(1);
        if (userAnswers[1] == max)
            answer.add(2);
        if (userAnswers[2] == max)
            answer.add(3);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args)
    {
        GiveUpUser g = new GiveUpUser();
        int[] participant = {1, 2, 3, 4, 5};
        g.solution(participant);
    }
}
