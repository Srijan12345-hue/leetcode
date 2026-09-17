import java.util.*;

class Solution {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list =
                new ArrayList<>(map.entrySet());

        while(!list.isEmpty()) {

            int max = 0;
            int index = 0;

            // Find maximum frequency
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getValue() > max) {
                    max = list.get(i).getValue();
                    index = i;
                }
            }

            Character c = list.get(index).getKey();

            // Add character max times
            for(int j = 0; j < max; j++) {
                ans.append(c);
            }

            // Remove processed character
            list.remove(index);
        }

        return ans.toString();
    }
}