import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IgreService {
	public static List<Zapis> listIgre() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("igre.ddat"))) {
			return (List<Zapis>) ois.readObject();
		} catch(EOFException e) {
			saveIgre(new ArrayList<>());
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void saveIgre(List<Zapis> igre) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("igre.ddat"))) {
			oos.writeObject(igre);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
