
package two_pointers;

public class BackspaceStringCompare {
    private static boolean backspaceCompare(String s, String t) {
        int sIdx = s.length() - 1;
        int tIdx = t.length() - 1;
        while (sIdx >= 0 || tIdx >= 0) {
            int nextValidSIdx = nextValidCharacter(s, sIdx);
            int nextValidTIdx = nextValidCharacter(t, tIdx);
            if (nextValidSIdx == -1 && nextValidTIdx == -1)
                return true;
            if (nextValidSIdx == -1 || nextValidTIdx == -1)
                return false;
            if (s.charAt(nextValidSIdx) != t.charAt(nextValidTIdx))
                return false;
            sIdx = nextValidSIdx - 1;
            tIdx = nextValidTIdx - 1;
        }
        return true;
    }

    private static int nextValidCharacter(String str, int idx) {
        int backspaceCount = 0, nextValidIndex = idx;
        while (nextValidIndex >= 0) {
            if (str.charAt(nextValidIndex) == '#')
                backspaceCount++;
            else if (backspaceCount > 0)
                backspaceCount--;
            else
                break;
            nextValidIndex--;
        }
        return nextValidIndex;
    }

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
        s = "ab##";
        t = "c#d#";
        System.out.println(backspaceCompare(s, t));
        s = "a#c";
        t = "b";
        System.out.println(backspaceCompare(s, t));
    }
}
