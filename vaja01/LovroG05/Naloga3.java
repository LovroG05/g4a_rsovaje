public class Naloga3 {
    public static void main(String[] args) {

    }

    public static int mestoNajmanjšega(int[] tab, int mesto, int najmanjši) {
        if (mesto != tab.length) {
            if (mesto == 0) {
                najmanjši = mesto;
                mesto++;
                mestoNajmanjšega(tab, mesto, najmanjši);
            } else if (tab[mesto] < tab[najmanjši]) {
                najmanjši = mesto;
                mesto++;
                mestoNajmanjšega(tab, mesto, najmanjši);
            }
        }

        return najmanjši;
    }
}
