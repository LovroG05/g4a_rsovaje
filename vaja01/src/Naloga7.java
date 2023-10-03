public class Naloga7 {
        public static void main(String[] args) {
            int stevilo = 12345;
            int obrnjenoStevilo = obrniStevilo(stevilo);
            System.out.println("Obrnjeno število: " + obrnjenoStevilo);

            String niz = "Hello, World!";
            String obrnjenNiz = obrniNiz(niz);
            System.out.println("Obrnjen niz: " + obrnjenNiz);
        }

        public static int obrniStevilo(int stevilo) {
            if (stevilo < 10) {
                // Število ima samo eno števko, zato ga vrnemo neposredno.
                return stevilo;
            } else {
                // Preobrne števko na desni strani in rekurzivno obrne preostanek števila.
                int zadnjaStevka = stevilo % 10;
                int preostanekStevila = stevilo / 10;
                int obrnjenPreostanek = obrniStevilo(preostanekStevila);
                int potenciranaStevka = (int) (zadnjaStevka * Math.pow(10, (int) Math.log10(obrnjenPreostanek) + 1));
                return obrnjenPreostanek + potenciranaStevka;
            }
        }

    public static String obrniNiz(String niz) {
        if (niz.isEmpty()) {
            // Če je niz prazen, ga vrnemo kot takšnega.
            return niz;
        } else {
            // Vzamemo prvi znak niza, ga odstranimo iz niza in rekurzivno obrnemo preostanek niza.
            char prviZnak = niz.charAt(0);
            String preostanekNiza = niz.substring(1);
            String obrnjenPreostanek = obrniNiz(preostanekNiza);
            return obrnjenPreostanek + prviZnak;
        }
    }


}
