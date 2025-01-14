import java.util.HashMap;

class LongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> substring = new HashMap<Character, Integer>();
        int stringLength = s.length();
        int longsetSubstring = 0;

        int j = 0;
        for (int i = 0; i < stringLength; i++) {
            char c = s.charAt(i);
            Integer duplicateIndex = substring.get(c);
            if (duplicateIndex != null && duplicateIndex >= j) {

                int subStringSize = i - j;
                j = duplicateIndex + 1;
                if (subStringSize > longsetSubstring) {
                    longsetSubstring = subStringSize;
                }

            }
            substring.put(c, i);
        }

        int subStringSize = stringLength - j;
        if (subStringSize > longsetSubstring) {
            longsetSubstring = subStringSize;
        }

        return longsetSubstring;
    }
}
