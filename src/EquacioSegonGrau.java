import java.util.Scanner;

public class EquacioSegonGrau {
    public void calcularEquacioQuadratica() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Introdueix els coeficients a, b i c");
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            double discriminant = b * b - 4.0 * a * c;

            if (a == 0) {
                throw new IllegalArgumentException("El coeficient 'a' no pot ser zero.");
            } else if (discriminant < 0) {
                throw new DiscriminantNegativeException("El discriminant és negatiu.");
            } else {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        } catch (NumberFormatException e) {
            System.out.println("Introdueix només números enters.");
        } catch (IllegalArgumentException | DiscriminantNegativeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static class DiscriminantNegativeException extends Exception {
        public DiscriminantNegativeException(String message) {
            super(message);
        }
    }
}
