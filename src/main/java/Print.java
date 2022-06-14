import java.util.*;

public class Print {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities)
            queue.add(priority);

        while (!queue.isEmpty())
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    answer++;
                    queue.poll();
                }
            }
        return answer;
    }

    public static void main(String[] args) {
        Print print = new Print();
        print.solution(new int[]{1, 1, 9, 1, 1, 1}, 1);
    }
}
