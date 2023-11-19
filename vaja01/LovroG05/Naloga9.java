public class Naloga9 {
    public static void main(String[] args) {
        int n = 5; // Spremenite na želeno število za izračun faktorja.
        long faktor = izracunajFaktor(n);
        System.out.println(n + "! = " + faktor);
    }

    public static long izracunajFaktor(int n) {
        if (n == 0 || n == 1) {
            // Faktor za 0 in 1 je 1.
            return 1;
        } else {
            // Faktor za n je n pomnožen z faktorjem (n-1).
            return (long) n * izracunajFaktor(n - 1);
        }
    }
}
