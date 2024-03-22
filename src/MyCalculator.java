import java.util.Scanner;

public class MyCalculator {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scan.nextInt();
        int p = scan.nextInt();
        longPower(n,p);
    }

    public static void longPower(int n, int p) throws Exception {
        if (n == 0 || p == 0) throw new Exception("Ni n ni p poden ser zero");
        if (n < 0 || p < 0) throw new Exception("Ni n ni p poden ser negatius");

        double pot = Math.pow(n, p);

        System.out.println(pot);


    }
}
