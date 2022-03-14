import java.util.ArrayList;
import java.util.List;

public class GymClothes
{
    //문제 : https://programmers.co.kr/learn/courses/30/lessons/42862
    public int solution(int n, int[] lost, int[] reserve)
    {
        int answer = n - lost.length;

        //여분 체육복이 있지만 체육복을 잃어버린 사람 제거
        List<Integer> list = new ArrayList<>();
        loop:
        for (int i : reserve)
            for (int j : lost)
                if (i == j)
                {
                    list.add(j);
                    continue loop;
                }

        answer += list.size();

        loop:
        for (int i : reserve)
            for (int j : lost)
                if (!list.contains(i))
                {
                    if (i - j == -1 || i - j == 1)
                    {
                        list.add(j);
                        answer++;
                        continue loop;
                    }
                }

        return answer;
    }

    public static void main(String[] args)
    {
        GymClothes gymClothes = new GymClothes();
        gymClothes.solution(5, new int[]{2,4}, new int[]{1,3,5});
    }
}
