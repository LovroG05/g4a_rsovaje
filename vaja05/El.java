import java.util.LinkedList;
/**
 * class El 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class El{
    public javafx.scene.paint.Color barva;
    public Element koordinata;
    
    public El(javafx.scene.paint.Color barva,Element koordinata){
      this.barva = barva;
      this.koordinata = koordinata;
    }
    
    public String toString(){
       return "<"+koordinata+">";
    }
}
