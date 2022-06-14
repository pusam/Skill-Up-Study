import java.util.ArrayList;
import java.util.List;

public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int sum = progresses[i];
            int cnt = 0;
            while (sum < 100) {
                sum += speeds[i];
                cnt++;
            }
            days[i] = cnt;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < days.length; i++) {
            int cnt = 1;
            if (days[i] < 0) continue;
            for (int j = i + 1; j < days.length; j++) {
                if (days[i] >= days[j]) {
                    days[j] = -1;
                    cnt++;
                } else {
                    break;
                }
            }
            list.add(cnt);
        }

        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        FunctionDev functionDev = new FunctionDev();
        functionDev.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }
}