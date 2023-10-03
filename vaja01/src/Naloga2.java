public class Naloga2 {
    public static void main(String[] args) {
        int[] a = new int[41];
        isPal(a);
    }

    public static boolean isPal(int[] s) {
        if(s.length == 0 || s.length == 1)
            return true;
        if(s[0] == s[s.length-1])
            return isPal(subtabela(s, 1, s.length-1));

        return false;
    }

    public static int[] subtabela(int[] a, int first, int last){
        int[] n = new int[last-first];
        for (int i = 0; i <= last; i++) {
            if (i>=first) {
                n[i-first] = a[i];
            }
        }

        return n;
    }
}
