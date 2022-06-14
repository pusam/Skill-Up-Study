import java.util.ArrayList;

public class NewsClustering {
    public ArrayList<String> getMultipleLists(String str) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            String e = str.substring(i - 1, i + 1);
            if (e.charAt(0) < 97 || e.charAt(0) > 122) continue;
            if (e.charAt(1) < 97 || e.charAt(1) > 122) continue;
            list.add(e);
        }
        return list;
    }

    public int solution(String str1, String str2) {
        ArrayList<String> list1 = getMultipleLists(str1.toLowerCase());
        ArrayList<String> list2 = getMultipleLists(str2.toLowerCase());
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> inter = new ArrayList<>();

        if (list1.size() == 0 && list2.size() == 0) return 65536;

        for (String e : list1) {
            if (list2.remove(e)) inter.add(e);
        }
        union.addAll(list1);
        union.addAll(list2);
        double similar = (double) inter.size() / (union.size() == 0 ? 1 : union.size());
        return (int) (similar * 65536);
    }

    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();
        newsClustering.solution("aa1+aa2", "AAAA12");

    }
}