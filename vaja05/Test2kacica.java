import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a description of class Test2 here.
 * <p>
 * <p>
 * uporabimo Queue interface na LinkedList-u, in uporabimo zgolj metode iz
 * Queue (add - doda na konec vrste, remove, odstrani z začetka vrste)
 * <p>
 * - ideja : glava kače je dejansko rep vrste(queue)
 * premaknemo tako, da iz glave vrste(rep kače) odstranimo el. in
 * kačo premaknemo tako, da v glavo dodamo nov element v smeri gibanja
 * (glej konstruktor !)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test2kacica {
	private Queue kaca = new LinkedList<El>();

	private El glavaKace;
	private Smer smer;
	private Color barva;

	private HashMap<Element, El> ovire = new HashMap<>();

	/**
	 * naredi 'koliko' dolgo kačo, na naključni začetni poziciji z naključno začetno
	 * smerjo gibanja
	 */
	public Test2kacica(int koliko) {
		this.smer = new Smer();
		this.barva = Color.GREEN;

		// Obrni random
		for(int i = 0; i < (int) (Math.random() * 5); i++) {
			smer.ccw();
		}

		// Random na koord. sistemu
		Element randomPozicija = new Element(
				(int) (Math.random() * (800 - 4 * koliko)) + 2 * koliko,
				(int) (Math.random() * (600 - 4 * koliko)) + 2 * koliko
		);

		glavaKace = new El(barva, randomPozicija);
		kaca.add(glavaKace);

		// Naredi kaco
		while(--koliko > 0) {
			El temp = new El(
					barva,
					new Element(
							glavaKace.koordinata.x() + smer.getX(),
							glavaKace.koordinata.y() + smer.getY()
					)
			);

			kaca.add(temp);
			glavaKace = temp;
		}

		//Zgenerirajmo ovire
		for(int i = 0; i < 100; i++) {
			Element rand = new Element(
					(int) (Math.random() * 800),
					(int) (Math.random() * 600)
			);

			ovire.put(rand, new El(Color.AQUA, rand));
		}
	}

	private void premakni() {
		El temp = new El(
				barva,
				new Element(
						glavaKace.koordinata.x() + smer.getX(),
						glavaKace.koordinata.y() + smer.getY()
				)
		);

		kaca.add(temp);
		glavaKace = temp;
		kaca.remove();
	}

	public boolean naprej(int korakov) {
		for(int i = 0; i < korakov; i++) {
			if(!ovire.containsKey(new Element(glavaKace.koordinata.x() + smer.getX(), glavaKace.koordinata.y() + smer.getY()))) {
				premakni();
			} else {
				return false;
			}
		}

		return true;
	}

	public void obrniLevo() {
		smer.cw();
	}

	public void obrniDesno() {
		smer.ccw();
	}

	public Queue<El> getKaca() {
		return kaca;
	}

	public HashMap<Element, El> getOvire() {
		return ovire;
	}

	public static void main(String[] args) {
		Test2kacica k1 = new Test2kacica(5);

		System.out.println(k1.kaca);

		k1.naprej(3);
		System.out.println(k1.kaca);

		k1.obrniLevo();
		System.out.println(k1.kaca);

		k1.naprej(2);
		System.out.println(k1.kaca);
	}
}
