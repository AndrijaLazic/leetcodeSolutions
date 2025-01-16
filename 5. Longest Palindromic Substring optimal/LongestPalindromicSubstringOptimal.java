public class LongestPalindromicSubstringOptimal {

    public String longestPalindrome(String s) {
        int stringLength = s.length();
        char[] chars = s.toCharArray();
        String longestPalindrome = "";
        int longestPalindromeSize = 0;

        if(stringLength < 2)
            return s;

        for (int i = 0; i < stringLength; i++) {
            int left = i;
            int right = i;
            while (right < stringLength){
                if(chars[left] == chars[right]){
                    right++;
                }else{
                    break;
                }
            }
            right--;

            while (left >= 0 && right < stringLength){
                if(chars[left] == chars[right]){
                    left--;
                    right++;
                }else{
                    break;
                }
            }

            int palindromeSize = right - left - 1;
            if(palindromeSize > longestPalindromeSize){
                longestPalindromeSize = palindromeSize;
                longestPalindrome = s.substring(left + 1, right);
            }
        }
        return longestPalindrome;
    }



    public static void main(String[] args) {
        LongestPalindromicSubstringOptimal l = new LongestPalindromicSubstringOptimal();
        System.out.println(l.longestPalindrome("bb"));
    }
}
