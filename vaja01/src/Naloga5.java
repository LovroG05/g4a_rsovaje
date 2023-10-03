public class Naloga5 {
    public static void main(String[] args) {

    }

    public static int[] genPalindrom(int[] niz, int i, int n) {
        if (i != niz.length) {
            if (i <= niz.length/2) {
                niz[i] = n;
                i++;
                n++;
            } else if (i > niz.length/2) {
                n--;
                niz[i] = i;
                i++;
            }
            genPalindrom(niz, i, n);
        }

        return niz;

    }
}
