public class rendimiento {
    public static void main(String[] args) {
        for (int i = 0; i < 100_000_0000; i++) {
            if(i%10_000_0000==0)
                System.out.println(i);
        }
    }
}
