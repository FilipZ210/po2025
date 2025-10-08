public class Choinka {
    public static void main(String[] args) {
        String star = "*";
        int height = Integer.parseInt(args[0]);
        for (int i = 0; i < height; i++) {
            System.out.println(star);
            star += "*";
        }
    }
}