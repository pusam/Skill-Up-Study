public class ExpectedDraw {
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        do
        {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;

        } while (a != b);
        return answer;
    }

    public static void main(String[] args)
    {
        ExpectedDraw expectedDraw = new ExpectedDraw();
        expectedDraw.solution(8, 8, 1);
    }
}
