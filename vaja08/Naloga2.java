import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Naloga2 {
	public static void main(String[] args) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("zapisi.dat", true))) {
			for(int i = 0; i < 5; i++) {
				Zapis zapis = new Zapis((char) (65 + i), (char) (97 + i), new byte[15]);
				dos.writeChar(zapis.getA());
				dos.writeChar(zapis.getB());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
