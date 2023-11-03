import java.util.HashMap;
/**
 * class Test 
 * 
 * - glej deklaracijo z var
 * - test delovanja oz. uporabnosti HashMap-a
 * 
 * HashMap je dvodelna struktura: vsak element strukture 
 * ima ključ (identifikator) in vrednost:
 *    <kljuc,vrednost>
 * ključi predstavljajo asociativni del strukture: so enolični
 * (množica) s časovnostjo iskanja O(1)
 * 
 * iskanje po poziciji oz. Element-u : struktura h2
 *
 * @author (your name)
 * @version (a version number or a date)
 * 

 */
public class Test{
    public static void main(String[] args){
        Element e1 = new Element(1, 2);
        var e2 = new Element(4, 7);
        
        System.out.println(e2.x() + " " + e2.y());
        
        var h = new HashMap<Integer, Element>();
        
        h.put(1, e1);
        h.put(2, e2);
        
        System.out.println(h);
        
        System.out.println(h.containsValue(e1));
        
        
        System.out.println(h.containsValue(new Element(1,2)));
        
        var h2 = new HashMap<Element, Integer>();
        
        h2.put(new Element(3, 4), 1);
        h2.put(new Element(3, 5), 2);
        System.out.println(h2);
    }
}
