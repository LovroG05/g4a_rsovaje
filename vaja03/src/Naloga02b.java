import java.awt.Color;
import java.util.LinkedList;

public class Naloga02b {
    public static void main(String[] args) {
        LinkedList<RTocka> ll = new LinkedList<>();

        // Vstavimo 7 točk z enako y-koordinato, zaporedne x-koordinate in rumeno barvo.
        for (int i = 0; i < 7; i++) {
            ll.add(new RTocka(5 + i, 4, Color.yellow));
        }

        System.out.println("Izvajamo krožen premik za cel cikel:");
        for (int i = 0; i < ll.size(); i++) {
            RTocka prvi = ll.removeFirst(); // Odstranimo prvi element
            int newX = prvi.x() + 1; // Povečamo x-koordinato za 1
            Color newColor = (i == ll.size() - 1) ? Color.yellow : Color.red; // Nastavimo barvo

            RTocka novElement = new RTocka(newX, prvi.y(), newColor);
            ll.addLast(novElement); // Dodamo nov element na konec seznama
            System.out.println(ll);
        }
    }
}
