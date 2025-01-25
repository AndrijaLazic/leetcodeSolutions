public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int pointerA = 0;
        int pointerB = 0;

        int lengthA = t.length();
        int lengthB = s.length();

        while (pointerA < lengthA && pointerB < lengthB) {
            if(t.charAt(pointerA) == s.charAt(pointerB))
                pointerB++;
            pointerA++;
        }

        return pointerB == lengthB;
    }

    public static void main(String[] args) {
        IsSubsequence i = new IsSubsequence();
        System.out.println(i.isSubsequence("abc", "ahbgdc"));
        System.out.println(i.isSubsequence("axc", "ahbgdc"));
    }
}
