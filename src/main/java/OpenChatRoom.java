import java.util.*;

public class OpenChatRoom
{
    public String[] solution(String[] record) {
        List<String> logs = new ArrayList<>();
        Map<String, String> userMap = new LinkedHashMap<>();
        for (int i =0; i<record.length; i++)
        {
            String[] splitString = record[i].split(" ");
            String mode = splitString[0];
            String id = splitString[1];

            switch(mode)
            {
                case "Enter":
                    userMap.put(id, splitString[2]);
                    logs.add(id + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    logs.add(id + "님이 나갔습니다.");
                    break;
                case "Change":
                    userMap.put(id, splitString[2]);
            }
        }

        String[] answer = new String[logs.size()];
        for(int i=0; i<logs.size(); i++)
        {
            String userKey = logs.get(i).substring(0, logs.get(i).indexOf("님"));
            answer[i] = logs.get(i).replace(userKey, userMap.get(userKey));
        }

        return answer;
    }

    public static void main(String[] args)
    {
        OpenChatRoom openChatRoom = new OpenChatRoom();
        openChatRoom.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }
}