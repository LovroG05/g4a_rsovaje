public class Naloga6 {
        public static void main(String[] args) {
            String niz = "To je primer izbranega podniza v nizu podniz podniz";
            String iskaniPodniz = "podniz";

            int steviloPojavitev = prestejPojavitvePodniza(niz, iskaniPodniz);
            System.out.println("Število pojavitev podniza: " + steviloPojavitev);
        }

        public static int prestejPojavitvePodniza(String niz, String iskaniPodniz) {
            if (niz.length() < iskaniPodniz.length()) {
                return 0;
            }

            if (niz.substring(0, iskaniPodniz.length()).equals(iskaniPodniz)) {
                // Najdena je ena pojavitve podniza, nadaljujemo s preverjanjem preostanka niza.
                return 1 + prestejPojavitvePodniza(niz.substring(iskaniPodniz.length()), iskaniPodniz);
            } else {
                // Podniza ni na začetku, zato nadaljujemo z iskanjem v preostanku niza.
                return prestejPojavitvePodniza(niz.substring(1), iskaniPodniz);
            }
        }
}
