import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReportResult
{
    /*
    신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.

각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.

유저 ID	유저가 신고한 ID	설명
"muzi"	"frodo"	"muzi"가 "frodo"를 신고했습니다.
"apeach"	"frodo"	"apeach"가 "frodo"를 신고했습니다.
"frodo"	"neo"	"frodo"가 "neo"를 신고했습니다.
"muzi"	"neo"	"muzi"가 "neo"를 신고했습니다.
"apeach"	"muzi"	"apeach"가 "muzi"를 신고했습니다.
     */

    public int[] solution(String[] id_list, String[] report, int k)
    {
        int[] reportCnt = new int[id_list.length];
        String[] reports = Arrays.stream(report).distinct().toArray(String[]::new);
        Map<String, Integer> map = new LinkedHashMap<>();
        int num = 0;
        for (int i = 0; i < id_list.length; i++)
        {
            map.put(id_list[i], 0);
            for (String r : reports)
            {
                String[] splitReport = r.split(" ");
                if (id_list[i].equals(splitReport[1]) && !id_list[i].equals(splitReport[0]))
                    num++;
            }
            reportCnt[i] = num;
            num = 0;
        }

        for (int i = 0; i < id_list.length; i++)
            if (reportCnt[i] >= k)
                for (String r : reports)
                {
                    String[] splitReport = r.split(" ");
                    if (splitReport[1].equals(id_list[i]))
                        if (map.containsKey(splitReport[0]))
                            map.put(splitReport[0], map.get(splitReport[0]) + 1);
                }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++)
            answer[i] = map.get(id_list[i]);

        return answer;
    }

    public static void main(String[] args)
    {
        ReportResult reportResult = new ReportResult();
        //[2,1,1,0]
        reportResult.solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
    }
}
