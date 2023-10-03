public class Naloga4 {
    public static void main(String[] args) {

    }

    public static int[][] zapiši(int[][] tab, int x, int y) {
        if (y != 4) {
            if (x != 4) {
                x++;
            } else {
                x = 0;
                y++;
            }
            tab[y][x] = 1;
        }

        return tab;
    }
}
