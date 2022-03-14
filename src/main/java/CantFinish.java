import java.util.Arrays;

public class CantFinish
{
    //문제 : https://programmers.co.kr/learn/courses/30/lessons/42576
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i=0; i<completion.length; i++)
        {
            if (!participant[i].equals(completion[i]))
                break;
        }
        return participant[i];
    }

    public static void main(String[] args)
    {
        CantFinish cantFinish = new CantFinish();
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        cantFinish.solution(participant, completion);
    }
}
