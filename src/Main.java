import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcio;
        do {

            System.out.println("1. Exercici 1");
            System.out.println("2. Exercici 2");
            System.out.println("3. Exercici 3");
            System.out.print("Entra una opció (0-3): ");
            opcio = scan.nextInt();
            scan.nextLine();
            switch (opcio) {
                case 1:
                    MyCalculator myCalculator = new MyCalculator();

                    System.out.println("Escriu dos numeros per fer la enèssima potència d’un número: ");
                    try {
                        int n = scan.nextInt();
                        int p = scan.nextInt();

                        long resultat = myCalculator.power(n, p);
                        System.out.println(resultat);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Escriu dos numeros per fer la seva divisio: ");
                        int x = scan.nextInt();
                        int y = scan.nextInt();

                        if (y == 0) {
                            throw new ArithmeticException("/ by zero");
                        }

                        int resultat = x / y;
                        System.out.println(resultat);
                    } catch (InputMismatchException e) {
                        System.out.println("java.util.InputMismatchException");
                    } catch (ArithmeticException e) {
                        System.out.println("java.lang.ArithmeticException: " + e.getMessage());
                    }
                    break;

                case 3:
                    EquacioSegonGrau equacioSegonGrau = new EquacioSegonGrau();

                    try {
                        equacioSegonGrau.calcularEquacioQuadratica();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            scan.nextLine();
        } while (opcio != 0);
    }
}




