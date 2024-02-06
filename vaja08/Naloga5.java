public class Naloga5 {
	public static void main(String[] args) {
		ZapisService.izpisiVse(ZapisService.getVse());
		ZapisService.updateN(4, new Zapis('W', 'W', new byte[15]));

		System.out.println();
		ZapisService.izpisiVse(ZapisService.getVse());
	}
}
