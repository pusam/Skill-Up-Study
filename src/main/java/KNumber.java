import java.util.Arrays;

public class KNumber
{
    //문제 https://programmers.co.kr/learn/courses/30/lessons/42748
    public int[] solution(int[] array, int[][] commands)
    {
        int size = commands.length;
        int[] answer = new int[size];
        for (int i=0; i<size; i++)
        {
            int[] copyArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(copyArray);
            answer[i] = copyArray[commands[i][2] - 1];
        }
        return answer;
    }

    public static void main(String[] args)
    {
        KNumber k = new KNumber();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        k.solution(array, commands);
    }
}
