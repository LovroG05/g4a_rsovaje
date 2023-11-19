public class Naloga8 {
        public static void main(String[] args) {
            int a = 48;
            int b = 18;
            int nsd = najvecjiSkupniDelitelj(a, b);
            System.out.println("Največji skupni delitelj števil " + a + " in " + b + " je: " + nsd);
        }

        public static int najvecjiSkupniDelitelj(int a, int b) {
            if (b == 0) {
                // Ko dosežemo, da je drugo število enako 0, prvo število je NSD.
                return a;
            } else {
                // Sicer rekurzivno nadaljujemo z drugim številom kot prvim in ostanek prvega števila z deljenjem z drugim številom.
                return najvecjiSkupniDelitelj(b, a % b);
            }
        }

}
