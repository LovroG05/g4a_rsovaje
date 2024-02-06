import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ZapisService {
	public static void izpisiVse(List<Zapis> zapis) {
		for(Zapis z : zapis) {
			System.out.println(z);
		}
	}

	public static List<Zapis> getVse() {
		ArrayList<Zapis> toReturn = new ArrayList<>();

		try(DataInputStream dis = new DataInputStream(new FileInputStream("zapisi.dat"))) {
			while(dis.available() >= 17) {
				toReturn.add(new Zapis(dis.readChar(), dis.readChar(), dis.readNBytes(15)));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

		return toReturn;
	}

	public static void zapisiVse(List<Zapis> zapisi) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("zapisi.dat"))) {
			for(Zapis z : zapisi) {
				dos.writeChar(z.getA());
				dos.writeChar(z.getB());

				for(byte b : z.getC()) {
					dos.writeByte(b);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static int countAll() {
		return getVse().size();
	}

	public static void updateN(int n, Zapis z) {
		List<Zapis> zapisi = ZapisService.getVse();
		zapisi.set(n, z);
		ZapisService.zapisiVse(zapisi);
	}

	public static void removeN(int n) {
		List<Zapis> zapisi = ZapisService.getVse();
		zapisi.remove(n);
		ZapisService.zapisiVse(zapisi);
	}
}
