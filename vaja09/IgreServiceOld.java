import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class IgreServiceOld {
	private IgreServiceOld() {
	}

	public static List<Zapis> listIgre() {
		ArrayList<Zapis> toReturn = new ArrayList<>();

		try(RandomAccessFile raf = new RandomAccessFile(new File("igre.dat"), "r")) {
			while(raf.read() > -1) {
				raf.seek(raf.getFilePointer() - 1);
				// Parse key
				char[] igralec = new char[15];
				for(int i = 0; i < 15; i++) {
					igralec[i] = raf.readChar();
				}

				// Parse other
				int najbolsiDosezek = raf.readInt();
				int steviloPoskusov = raf.readInt();

				toReturn.add(new Zapis(igralec, najbolsiDosezek, steviloPoskusov));
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}

		return toReturn;
	}

	public static void saveIgre(List<Zapis> igre) {
		try(RandomAccessFile raf = new RandomAccessFile(new File("igre.dat"), "rw")) {
			for(Zapis z : igre) {
				for(char c : z.getIgralec()) {
					raf.writeChar(c);
				}

				raf.writeInt(z.getNajbolsiDosezek());
				raf.writeInt(z.getSteviloPoskusov());
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
