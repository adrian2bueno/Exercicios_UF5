import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.net.Socket;
import java.net.SocketException;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.EOFException;

public class Exemples_ErrorsExceptions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcio;
        do {
            System.out.println("1. Error > OutOfMemoryError");
            System.out.println("2. Error > stackOverFlowError");
            System.out.println("3. RunTimeException > IllegalArgumentExceptions");
            System.out.println("4. RunTimeException > ArithmeticException");
            System.out.println("5. RunTimeException > IndexOutOfBoundException");
            System.out.println("6. RunTimeException > NullPointerException");
            System.out.println("7. IOException > SocketException");
            System.out.println("8. IOException > FileNotFoundException");
            System.out.println("9. IOException > EOFException");
            System.out.println("0. Acabar");
            System.out.print("Entra una opció (0-9): ");
            opcio = scan.nextInt();
            scan.nextLine();
            switch (opcio) {
                case 1:
                    outOfMemoryError();
                    break;
                case 2:
                    stackOverFlowError();
                    break;
                case 3:
                    illegalArgumentExceptionsMath();
                    illegalArgumentExceptionsArrays();
                    break;
                case 4:
                    arithmeticException();
                    break;
                case 5:
                    indexOutOfBoundException();
                    break;
                case 6:
                    nullPointerException();
                    break;
                case 7:
                    socketException();
                    break;
                case 8:
                    fileNotFoundException();
                    break;
                case 9:
                    eOFException();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 9");
            }
        } while (opcio != 0);
    }

    static void outOfMemoryError(){
        List<Integer> list = new ArrayList<>();
        try {
            while (true) {
                list.add(999999999); // Afegim un nombre gran a la llista
            }
        } catch (OutOfMemoryError e) {
            System.out.println("S'ha produït un error d'excés de memòria (OutOfMemoryError)");
            // Dirà la línia i el mètode que dona error
            e.printStackTrace();
        }finally {
            System.out.println("Mètode tancat");
        }

    }
    static void stackOverFlowError() {
        try {
            cridaRecursiva(0);
        } catch (StackOverflowError e) {
            System.out.println("S'ha produït un error de desbordament de la pila (StackOverflowError)");
        }finally {

            System.out.println("Mètode tancat");
        }
    }
    public static void cridaRecursiva(int i) {
        System.out.println("Número: " + i);
        cridaRecursiva(i + 1); // Crida recursiva infinita
    }

    static void illegalArgumentExceptionsArrays(){
        int[] array = {10, 20, 30, 40, 50};
        try {
            int index = trobarElement(array, 60); // provem de trobar l'index d'un element que no es troba a l'array
            System.out.println("index element: " + index);
        } catch (IllegalArgumentException e) {
            System.out.println("S'ha produït un error d'argument no vàlid (IllegalArgumentException): " + e.getMessage());
        }finally {
            System.out.println("Mètode tancat");
        }
    }

    public static int trobarElement(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        throw new IllegalArgumentException("L'element no es troba a l'array");
    }


    static void illegalArgumentExceptionsMath(){
        try {
            int result = arrelQuadrada(-1); // Intentem obtenir l'arrel quadrada d'un nombre negatiu
            System.out.println("Resultat: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("S'ha produït un error d'argument no vàlid (IllegalArgumentException): " + e.getMessage());

        }finally {
            System.out.println("Mètode tancat");
        }
    }

    public static int arrelQuadrada(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("El nombre no pot ser negatiu");
        }
        return (int) Math.sqrt(number);
    }

    static void arithmeticException(){
        try {
            int resultat = dividir(10, 0); // Intentem dividir 10 per zero
            System.out.println("Resultat de la divisió: " + resultat);
        } catch (ArithmeticException e) {
            System.out.println("S'ha produït un error d'aritmètica (ArithmeticException): " + e);
        }finally {
            System.out.println("Mètode tancat");
        }
    }

    public static int dividir(int dividend, int divisor) {
        if (divisor == 0) {
            // Si el divisor és zero, llancem una ArithmeticException
            throw new ArithmeticException("Divisió per zero no està permessa");
        }
        return dividend / divisor;
    }
    static void indexOutOfBoundException(){
        int[] array = {1, 2, 3, 4, 5};
        try {
            System.out.println("accedim a la posicio 6 de l'array!!!");
            int element = array[6]; // Intentem accedir a un índex fora dels límits de l'array
        } catch (IndexOutOfBoundsException e) {
            // Transforma l'idioma, data, temps dependent de la regio del missatge
            System.out.println("S'ha produït un error d'índex fora de límits (IndexOutOfBoundsException): " + e.getLocalizedMessage());
        }finally {
            System.out.println("Mètode tancat");
        }
    }
    static void nullPointerException(){
        String text = null;
        try {
            int length = text.length(); // Intentem obtenir la longitud d'una cadena nul·la
            System.out.println("Longitud del text: " + length);
        } catch (NullPointerException e) {
            // Mostra la causa principal d'un error
            System.out.println("S'ha produït un error de punter nul (NullPointerException): " + e.getCause());
        }finally {
            System.out.println("Mètode tancat");
        }
    }

    static void socketException(){
        try {
            connexioSrv("sapalomera.cat", 80); // Intentem connectar-nos a un servidor que pot no existir
        } catch (SocketException e1) {
            System.out.println("S'ha produït un error de connexió de xarxa (SocketException): " + e1.getMessage());
        } catch (IOException e2) {
            System.out.println("S'ha produït un error d'entrada/sortida (IOException): " + e2.getMessage());
        }finally {
            System.out.println("Mètode tancat");
        }
        //podriem fer només un catch amb una sola variable e >>> catch (SocketException | IOException e)
    }

    public static void connexioSrv(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        // Aquí es realitzaria la lògica de comunicació amb el servidor
        socket.close();
    }
    static void fileNotFoundException(){
        try {
            llegirSolucioExamen("solucio_examen_uf5.txt"); // Intentem llegir un fitxer que no existeix
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer: " + e.getMessage());
        }
    }
    public static void llegirSolucioExamen(String nomFitxer) throws FileNotFoundException {
        File fitxer = new File(nomFitxer);
        Scanner scanner = new Scanner(fitxer);
        // Aquí es realitzaria la lectura del fitxer
        scanner.close();
    }

    static void eOFException(){
        String nomFitxer = "notes_finals.dat";

        try (DataInputStream lectura = new DataInputStream(new FileInputStream(nomFitxer))){
            while (true) {
                int valor = lectura.readInt();
                System.out.println("Valor llegit: " + valor);
            }
        } catch (EOFException e1) {
            System.out.println("S'ha arribat al final del fitxer: " + e1.getMessage());
        } catch (IOException e2) {
            System.out.println("S'ha produït un error d'entrada/sortida: " + e2.getMessage());
        }finally {
            System.out.println("Mètode tancat");
        }
    }
}