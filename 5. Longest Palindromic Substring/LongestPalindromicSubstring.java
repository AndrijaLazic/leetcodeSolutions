public class LongestPalindromicSubstring
{
    public String longestPalindrome(String s) {
        int stringLength = s.length();
        char[] characters = s.toCharArray();
        String longestPalindrome = "";
        int longestPalindromeSize = 0;

        int j = stringLength - 1;
        for (int i = 0; i < stringLength; i++) {
            //longest size already found
            if(stringLength - i <= longestPalindromeSize)
                break;


            //iterate until we find start of a palindrome
            while(j > i){
                if(characters[i] == characters[j]){
                    break;
                }
                j--;
            }
            //if we don`t find a start of palindrome
            if(j < i){
                j = stringLength - 1;
                continue;
            }


            int possiblePalindromeSize = j - i + 1;
            //if possible palindrome is smaller than current longest
            if(possiblePalindromeSize < longestPalindromeSize){
                j = stringLength - 1;
                continue;
            }


            if(isPalindrome(characters, i, j, possiblePalindromeSize)){
                longestPalindrome = s.substring(i, j + 1);
                longestPalindromeSize = possiblePalindromeSize;
                i = j;
            }else{
                // if its not a palindrome we need to check same i again and look at new j
                j--;
                i--;
                continue;
            }

            j = stringLength - 1;
        }

        return longestPalindrome;
    }

    public static boolean isPalindrome(char[] characters, int i, int j, int possiblePalindromeSize){

        if(possiblePalindromeSize%2 == 0) {
            while (i < j){
                if(characters[i] != characters[j]){
                    break;
                }
                i++;
                j--;
            }

            if(i < j)
                return false;
        }
        else {
            while (i <= j){
                if(characters[i] != characters[j]){
                    break;
                }
                i++;
                j--;
            }

            if(i < j)
                return false;
        }

        return true;
    }


    public static void main(String[] args)
    {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        String s1 = "babadada";
        String s2 = "a";
        String s3 = "ac";
        String s4 = "aa";
        System.out.println(obj.longestPalindrome(s1));
        System.out.println(obj.longestPalindrome(s2));
        System.out.println(obj.longestPalindrome(s3));
        System.out.println(obj.longestPalindrome(s4));
    }
}
