public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        int strLength = s.length();

        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            char leftChar = s.charAt(left);

            if(!Character.isLetterOrDigit(leftChar)){
                left++;
                continue;
            }

            leftChar = Character.toLowerCase(leftChar);

            char rightChar = s.charAt(right);

            if(!Character.isLetterOrDigit(rightChar)){
                right--;
                continue;
            }

            rightChar = Character.toLowerCase(rightChar);

            if(leftChar != rightChar){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aa";
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome(s));
    }
}
