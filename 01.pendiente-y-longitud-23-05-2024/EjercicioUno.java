import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioUno {

    public static void main(String[] args) {
        double[] valores = new double[4];
        final int X1 = 0;
        final int Y1 = 1;
        final int X2 = 2;
        final int Y2 = 3;

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese X1");
        valores[X1] = scanner.nextDouble();

        System.out.println("Ingrese Y1");
        valores[Y1] = scanner.nextDouble();

        System.out.println("Ingrese X2");
        valores[X2] = scanner.nextDouble();

        System.out.println("Ingrese Y2");
        valores[Y2] = scanner.nextDouble();

        scanner.close();

        if (valores[X1] <= 0 || valores[Y1] <= 0) {
            System.out.println("Los valores X1 y Y1 deben ser mayores a 0");
            System.exit(1);
        }

        if (valores[X2] <= 9 || valores[Y2] <= 9) {
            System.out.println("Los valores X2 y Y2 deben ser mayores a 9");
            System.exit(1);
        }

        double longitud = Math.sqrt(Math.pow(valores[X2] - valores[X1], 2) + Math.pow(valores[Y2] - valores[Y1], 2));
        double pendiente = (valores[Y2] - valores[Y1]) / (valores[X2] - valores[X1]);

        if (Double.isNaN(pendiente)) {
            System.out.println("Error al calcular la pendiente: División entre cero.");
            System.exit(0);
        }

        try (FileWriter writer = new FileWriter("resultados.txt")) {
            writer.write("Resultados de la operacion:\n"
                    + "Longitud: " + longitud + "\n"
                    + "Pendiente: " + pendiente + "\n");
        } catch (IOException exception) {
            System.out.println("Error al guardar el archivo: " + exception.getMessage());
        }
    }
}
