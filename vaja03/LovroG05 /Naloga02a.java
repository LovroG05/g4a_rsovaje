import java.awt.Color;
import java.util.LinkedList;

public class Naloga02a {
    public static void main(String[] args) {
        LinkedList<RTocka> ll = new LinkedList<>();

        // Vstavimo 7 točk z enako y-koordinato, zaporedne x-koordinate in rumeno barvo.
        for (int i = 0; i < 7; i++) {
            ll.add(new RTocka(5 + i, 4, Color.yellow));
        }

        System.out.println("Izvajamo krožen premik za en 'krog/cikel':");
        for (int i = 0; i < ll.size(); i++) {
            RTocka element = ll.removeFirst(); // Odstranimo prvi element
            ll.addLast(element); // Dodamo ga na konec seznama
            System.out.println(ll);
        }
    }
}
