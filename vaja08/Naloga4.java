public class Naloga4 {
	public static void main(String[] args) {
		ZapisService.izpisiVse(ZapisService.getVse());
		ZapisService.removeN(2);

		System.out.println();
		ZapisService.izpisiVse(ZapisService.getVse());
	}
}
