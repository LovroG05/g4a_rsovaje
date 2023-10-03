public class Naloga1 {
    public static void main(String[] args) {
        izpiši(18, 2);
    }

    public static void izpiši(int od, int _do) {
        if (od >= _do) {
            System.out.println(od);
            od--;
            izpiši(od, _do);
        }
    }
}
