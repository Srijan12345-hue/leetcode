class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '(') {

                int left = i + 1;

                while (s.charAt(i) != ')') {
                    i++;
                }

                String key = s.substring(left, i);

                ans.append(map.getOrDefault(key, "?"));

            } else {
                ans.append(s.charAt(i));
            }

            i++;
        }

        return ans.toString();
    }
}